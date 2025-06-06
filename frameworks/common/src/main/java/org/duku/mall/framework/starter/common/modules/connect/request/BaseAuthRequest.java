package org.duku.mall.framework.starter.common.modules.connect.request;

import com.xkcoding.http.util.UrlUtil;
import org.duku.mall.framework.starter.common.common.utils.HttpUtils;
import org.duku.mall.framework.starter.common.modules.connect.config.AuthConfig;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;
import org.duku.mall.framework.starter.common.common.utils.UrlBuilder;
import org.duku.mall.framework.starter.common.common.utils.UuidUtils;
import org.duku.mall.framework.starter.common.modules.connect.config.ConnectAuth;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.AuthCallback;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.AuthResponse;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.AuthToken;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.ConnectAuthUser;
import org.duku.mall.framework.starter.common.modules.connect.entity.enums.AuthResponseStatus;
import org.duku.mall.framework.starter.common.modules.connect.exception.AuthException;
import org.duku.mall.framework.starter.common.modules.connect.utils.AuthChecker;

import java.util.List;


/**
 * 默认的request处理类，实现了 {@link AuthRequest} 接口，提供 {@link #login(AuthCallback)} 方法，
 * 用于处理OAuth2授权流程，包括获取accessToken，获取userInfo，取消授权等。
 */
@Slf4j
public abstract class BaseAuthRequest implements AuthRequest {
    protected AuthConfig config;
    protected ConnectAuth source;
    protected SingletonCache cache;


    public BaseAuthRequest(AuthConfig config, ConnectAuth connectAuth, SingletonCache cache) {
        this.config = config;
        this.source = connectAuth;
        this.cache = cache;
        if (!AuthChecker.isSupportedAuth(config, source)) {
            throw new AuthException(AuthResponseStatus.PARAMETER_INCOMPLETE, source);
        }
        //校验配置合法性
        AuthChecker.checkConfig(config, source);
    }

    /**
     * 获取access token
     *
     * @param authCallback 授权成功后的回调参数
     * @return token
     */
    protected abstract AuthToken getAccessToken(AuthCallback authCallback);

    /**
     * 使用token换取用户信息
     *
     * @param authToken token信息
     * @return 用户信息
     */
    protected abstract ConnectAuthUser getUserInfo(AuthToken authToken);

    /**
     * 统一的登录入口。当通过{@link AuthRequest#login(AuthCallback)} (String)}授权成功后，会跳转到调用方的相关回调方法中
     * 方法的入参可以使用{@code AuthCallback}，{@code AuthCallback}类中封装好了OAuth2授权回调所需要的参数
     *
     * @param authCallback 用于接收回调参数的实体
     * @return AuthResponse
     */
    @Override
    public AuthResponse login(AuthCallback authCallback) {
        try {
            AuthChecker.checkCode(source, authCallback);
            AuthToken authToken = this.getAccessToken(authCallback);
            ConnectAuthUser user = this.getUserInfo(authToken);
            return AuthResponse.builder().code(AuthResponseStatus.SUCCESS.getCode()).data(user).build();
        } catch (Exception e) {
            log.error("Failed to login with oauth authorization.", e);
            return this.responseError(e);
        }
    }

    /**
     * 处理{@link BaseAuthRequest#login(AuthCallback)} 发生异常的情况，统一响应参数
     *
     * @param e 具体的异常
     * @return AuthResponse
     */
    private AuthResponse responseError(Exception e) {
        String errorCode = AuthResponseStatus.FAILURE.getCode();
        String errorMsg = e.getMessage();
        if (e instanceof AuthException) {
            AuthException authException = ((AuthException) e);
            errorCode = authException.getErrorCode();
            if (StringUtils.isNotEmpty(authException.getErrorMsg())) {
                errorMsg = authException.getErrorMsg();
            }
        }
        return AuthResponse.builder().code(errorCode).msg(errorMsg).build();
    }

    /**
     * 返回带{@code state}参数的授权url，授权回调时会带上这个{@code state}
     *
     * @param state state 验证授权流程的参数，可以防止csrf
     * @return 返回授权地址
     * @since 1.9.3
     */
    @Override
    public String authorize(String state) {
        return UrlBuilder.fromBaseUrl(source.authorize())
                .queryParam("response_type", "code")
                .queryParam("client_id", config.getClientId())
                .queryParam("redirect_uri", config.getRedirectUri())
                .queryParam("state", getRealState(state))
                .build();
    }


    /**
     * 返回获取accessToken的url
     *
     * @param code 授权码
     * @return 返回获取accessToken的url
     */
    protected String accessTokenUrl(String code) {
        return UrlBuilder.fromBaseUrl(source.accessToken())
                .queryParam("code", code)
                .queryParam("client_id", config.getClientId())
                .queryParam("client_secret", config.getClientSecret())
                .queryParam("grant_type", "authorization_code")
                .queryParam("redirect_uri", config.getRedirectUri())
                .build();
    }

    /**
     * 返回获取accessToken的url
     *
     * @param refreshToken refreshToken
     * @return 返回获取accessToken的url
     */
    protected String refreshTokenUrl(String refreshToken) {
        return UrlBuilder.fromBaseUrl(source.refresh())
                .queryParam("client_id", config.getClientId())
                .queryParam("client_secret", config.getClientSecret())
                .queryParam("refresh_token", refreshToken)
                .queryParam("grant_type", "refresh_token")
                .queryParam("redirect_uri", config.getRedirectUri())
                .build();
    }

    /**
     * 返回获取userInfo的url
     *
     * @param authToken token
     * @return 返回获取userInfo的url
     */
    protected String userInfoUrl(AuthToken authToken) {
        return UrlBuilder.fromBaseUrl(source.userInfo()).queryParam("access_token", authToken.getAccessToken()).build();
    }

    /**
     * 返回获取revoke authorization的url
     *
     * @param authToken token
     * @return 返回获取revoke authorization的url
     */
    protected String revokeUrl(AuthToken authToken) {
        return UrlBuilder.fromBaseUrl(source.revoke()).queryParam("access_token", authToken.getAccessToken()).build();
    }

    /**
     * 获取state，如果为空， 则默认取当前日期的时间戳
     *
     * @param state 原始的state
     * @return 返回不为null的state
     */
    protected String getRealState(String state) {
        if (StringUtils.isEmpty(state)) {
            state = UuidUtils.getUUID();
        }
        /* 缓存state 回调时候验证缓存里是否有state，如果没有的话则代表是非法访问*/
        cache.put(state, state, 600L);
        return state;
    }

    /**
     * 通用的 authorizationCode 协议
     *
     * @param code code码
     * @return Response
     */
    protected String doPostAuthorizationCode(String code) {
        return new HttpUtils(config.getHttpConfig()).post(accessTokenUrl(code));
    }

    /**
     * 通用的 authorizationCode 协议
     *
     * @param code code码
     * @return Response
     */
    protected String doGetAuthorizationCode(String code) {
        return new HttpUtils(config.getHttpConfig()).get(accessTokenUrl(code));
    }

    /**
     * 通用的 用户信息
     *
     * @param authToken token封装
     * @return Response
     */
    @Deprecated
    protected String doPostUserInfo(AuthToken authToken) {
        return new HttpUtils(config.getHttpConfig()).post(userInfoUrl(authToken));
    }

    /**
     * 通用的 用户信息
     *
     * @param authToken token封装
     * @return Response
     */
    protected String doGetUserInfo(AuthToken authToken) {
        return new HttpUtils(config.getHttpConfig()).get(userInfoUrl(authToken));
    }

    /**
     * 通用的post形式的取消授权方法
     *
     * @param authToken token封装
     * @return Response
     */
    @Deprecated
    protected String doPostRevoke(AuthToken authToken) {
        return new HttpUtils(config.getHttpConfig()).post(revokeUrl(authToken));
    }

    /**
     * 通用的post形式的取消授权方法
     *
     * @param authToken token封装
     * @return Response
     */
    protected String doGetRevoke(AuthToken authToken) {
        return new HttpUtils(config.getHttpConfig()).get(revokeUrl(authToken));
    }

    /**
     * 获取以 {@code separator}分割过后的 scope 信息
     *
     * @param separator     多个 {@code scope} 间的分隔符
     * @param encode        是否 encode 编码
     * @param defaultScopes 默认的 scope， 当客户端没有配置 {@code scopes} 时启用
     * @return String
     * @since 1.16.7
     */
    protected String getScopes(String separator, boolean encode, List<String> defaultScopes) {
        List<String> scopes = config.getScopes();
        if (null == scopes || scopes.isEmpty()) {
            if (null == defaultScopes || defaultScopes.isEmpty()) {
                return "";
            }
            scopes = defaultScopes;
        }
        if (null == separator) {
            //默认为空格
            separator = " ";
        }
        String scopeStr = String.join(separator, scopes);
        return encode ? UrlUtil.urlEncode(scopeStr) : scopeStr;
    }
}
