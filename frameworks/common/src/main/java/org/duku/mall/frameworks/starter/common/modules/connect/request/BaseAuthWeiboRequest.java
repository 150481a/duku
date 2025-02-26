package org.duku.mall.frameworks.starter.common.modules.connect.request;

import com.alibaba.fastjson.JSONObject;
import com.xkcoding.http.support.HttpHeader;
import org.duku.mall.frameworks.starter.cache.SingletonCache;
import org.duku.mall.frameworks.starter.common.common.utils.HttpUtils;
import org.duku.mall.frameworks.starter.common.common.utils.IpUtils;
import org.duku.mall.frameworks.starter.common.common.utils.StringUtils;
import org.duku.mall.frameworks.starter.common.common.utils.UrlBuilder;
import org.duku.mall.frameworks.starter.common.modules.connect.config.AuthConfig;
import org.duku.mall.frameworks.starter.common.modules.connect.config.ConnectAuthEnum;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.dto.AuthCallback;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.dto.AuthResponse;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.dto.AuthToken;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.dto.ConnectAuthUser;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.enums.AuthResponseStatus;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.enums.AuthUserGender;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.enums.ConnectEnum;
import org.duku.mall.frameworks.starter.common.modules.connect.exception.AuthException;

/**
 * 微博登录
 */
public class BaseAuthWeiboRequest extends BaseAuthRequest {


    public BaseAuthWeiboRequest(AuthConfig config, SingletonCache cache) {
        super(config, ConnectAuthEnum.WEIBO, cache);
    }

    @Override
    protected AuthToken getAccessToken(AuthCallback authCallback) {
        String response = doPostAuthorizationCode(authCallback.getCode());
        JSONObject accessTokenObject = JSONObject.parseObject(response);
        if (accessTokenObject.containsKey("error")) {
            throw new AuthException(accessTokenObject.getString("error_description"));
        }
        return AuthToken.builder()
                .accessToken(accessTokenObject.getString("access_token"))
                .uid(accessTokenObject.getString("uid"))
                .openId(accessTokenObject.getString("uid"))
                .expireIn(accessTokenObject.getIntValue("expires_in"))
                .build();
    }

    @Override
    protected ConnectAuthUser getUserInfo(AuthToken authToken) {
        String accessToken = authToken.getAccessToken();
        String uid = authToken.getUid();
        String oauthParam = String.format("uid=%s&access_token=%s", uid, accessToken);

        HttpHeader httpHeader = new HttpHeader();
        httpHeader.add("Authorization", "OAuth2 " + oauthParam);
        httpHeader.add("API-RemoteIP", IpUtils.getLocalIp());
        String userInfo = new HttpUtils(config.getHttpConfig()).get(userInfoUrl(authToken), null, httpHeader, false);
        JSONObject object = JSONObject.parseObject(userInfo);
        if (object.containsKey("error")) {
            throw new AuthException(object.getString("error"));
        }
        return ConnectAuthUser.builder()
                .rawUserInfo(object)
                .uuid(object.getString("id"))
                .username(object.getString("name"))
                .avatar(object.getString("profile_image_url"))
                .blog(StringUtils.isEmpty(object.getString("url")) ? "https://weibo.com/" + object.getString("profile_url") : object
                        .getString("url"))
                .nickname(object.getString("screen_name"))
                .location(object.getString("location"))
                .remark(object.getString("description"))
                .gender(AuthUserGender.getRealGender(object.getString("gender")))
                .token(authToken)
                .source(ConnectEnum.WEIBO)
                .build();
    }

    /**
     * 返回获取userInfo的url
     *
     * @param authToken authToken
     * @return 返回获取userInfo的url
     */
    @Override
    protected String userInfoUrl(AuthToken authToken) {
        return UrlBuilder.fromBaseUrl(source.userInfo())
                .queryParam("access_token", authToken.getAccessToken())
                .queryParam("uid", authToken.getUid())
                .build();
    }

    @Override
    public String authorize(String state) {
        return UrlBuilder.fromBaseUrl(super.authorize(state))
                .queryParam("scope", "all")
                .build();
    }

    @Override
    public AuthResponse revoke(AuthToken authToken) {
        String response = doGetRevoke(authToken);
        JSONObject object = JSONObject.parseObject(response);
        if (object.containsKey("error")) {
            return AuthResponse.builder()
                    .code(AuthResponseStatus.FAILURE.getCode())
                    .msg(object.getString("error"))
                    .build();
        }
        //返回 result = true 表示取消授权成功，否则失败
        AuthResponseStatus status = object.getBooleanValue("result") ? AuthResponseStatus.SUCCESS : AuthResponseStatus.FAILURE;
        return AuthResponse.builder().code(status.getCode()).msg(status.getMsg()).build();
    }
}
