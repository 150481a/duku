package org.duku.mall.framework.starter.common.modules.connect.request;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;
import org.duku.mall.framework.starter.common.common.utils.UrlBuilder;
import org.duku.mall.framework.starter.common.modules.connect.config.ConnectAuthEnum;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.AuthCallback;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.AuthResponse;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.AuthToken;
import org.duku.mall.framework.starter.common.modules.connect.entity.dto.ConnectAuthUser;
import org.duku.mall.framework.starter.common.modules.connect.entity.enums.AuthResponseStatus;
import org.duku.mall.framework.starter.common.modules.connect.entity.enums.AuthUserGender;
import org.duku.mall.framework.starter.common.modules.connect.entity.enums.ConnectEnum;
import org.duku.mall.framework.starter.common.modules.connect.config.AuthConfig;
import org.duku.mall.framework.starter.common.modules.connect.exception.AuthException;

/**
 * 支付宝登录请求基类
 */
public class BaseAuthAlipayRequest extends BaseAuthRequest {
    private final AlipayClient alipayClient;


    public BaseAuthAlipayRequest(AuthConfig config, SingletonCache cache) {
        super(config, ConnectAuthEnum.ALIPAY, cache);
        this.alipayClient = new DefaultAlipayClient(ConnectAuthEnum.ALIPAY.accessToken(), config.getClientId(), config.getClientSecret(), "json", "UTF-8", config
                .getAlipayPublicKey(), "RSA2");
    }

    @Override
    protected AuthToken getAccessToken(AuthCallback authCallback) {
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(authCallback.getAuthCode());
        AlipaySystemOauthTokenResponse response = null;
        try {
            response = this.alipayClient.execute(request);
        } catch (Exception e) {
            throw new AuthException(e);
        }
        if (!response.isSuccess()) {
            throw new AuthException(response.getSubMsg());
        }
        return AuthToken.builder()
                .accessToken(response.getAccessToken())
                .uid(response.getUserId())
                .expireIn(Convert.toInt(response.getExpiresIn()))
                .refreshToken(response.getRefreshToken())
                .build();
    }

    /**
     * 刷新access token （续期）
     *
     * @param authToken 登录成功后返回的Token信息
     * @return AuthResponse
     */
    @Override
    public AuthResponse refresh(AuthToken authToken) {
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("refresh_token");
        request.setRefreshToken(authToken.getRefreshToken());
        AlipaySystemOauthTokenResponse response = null;
        try {
            response = this.alipayClient.execute(request);
        } catch (Exception e) {
            throw new AuthException(e);
        }
        if (!response.isSuccess()) {
            throw new AuthException(response.getSubMsg());
        }
        return AuthResponse.builder()
                .code(AuthResponseStatus.SUCCESS.getCode())
                .data(AuthToken.builder()
                        .accessToken(response.getAccessToken())
                        .uid(response.getUserId())
                        .expireIn(Convert.toInt(response.getExpiresIn()))
                        .refreshToken(response.getRefreshToken())
                        .build())
                .build();
    }

    @Override
    protected ConnectAuthUser getUserInfo(AuthToken authToken) {
        String accessToken = authToken.getAccessToken();
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        AlipayUserInfoShareResponse response = null;
        try {
            response = this.alipayClient.execute(request, accessToken);
        } catch (AlipayApiException e) {
            throw new AuthException(e.getErrMsg(), e);
        }
        if (!response.isSuccess()) {
            throw new AuthException(response.getSubMsg());
        }

        String province = response.getProvince(), city = response.getCity();
        String location = String.format("%s %s", StringUtils.isEmpty(province) ? "" : province, StringUtils.isEmpty(city) ? "" : city);

        return ConnectAuthUser.builder()
                .rawUserInfo(JSONObject.parseObject(JSONObject.toJSONString(response)))
                .uuid(response.getUserId())
                .username(StringUtils.isEmpty(response.getUserName()) ? response.getNickName() : response.getUserName())
                .nickname(response.getNickName())
                .avatar(response.getAvatar())
                .location(location)
                .gender(AuthUserGender.getRealGender(response.getGender()))
                .token(authToken)
                .source(ConnectEnum.ALIPAY)
                .build();
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
                .queryParam("app_id", config.getClientId())
                .queryParam("scope", "auth_user")
                .queryParam("redirect_uri", config.getRedirectUri())
                .queryParam("state", getRealState(state))
                .build();
    }
}
