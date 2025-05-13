package org.duku.mall.framework.starter.common.modules.connect.config;

import jakarta.security.auth.message.AuthException;
import org.duku.mall.framework.starter.common.modules.connect.entity.enums.AuthResponseStatus;

/**
 * OAuth平台的API地址的统一接口
 */
public interface ConnectAuth {


    /**
     * 授权的api
     *
     * @return url
     */
    String authorize();

    /**
     * 获取accessToken的api
     *
     * @return url
     */
    String accessToken();

    /**
     * 获取用户信息的api
     *
     * @return url
     */
    String userInfo();

    /**
     * 取消授权的api
     *
     * @return url
     */
    default String revoke() {
        throw new AuthException(AuthResponseStatus.UNSUPPORTED);
    }

    /**
     * 刷新授权的api
     *
     * @return url
     */
    default String refresh() {
        throw new AuthException(AuthResponseStatus.UNSUPPORTED);
    }

    /**
     * 获取Source的字符串名字
     *
     * @return name
     */
    default String getName() {
        if (this instanceof Enum) {
            return String.valueOf(this);
        }
        return this.getClass().getSimpleName();
    }
}
