package org.duku.mall.framework.starter.user.core;

import com.alibaba.ttl.TransmittableThreadLocal;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.user.core.enums.SecurityEnum;
import org.duku.mall.framework.starter.user.toolkit.JWTUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

/**
 * 用户的上下文信息
 */

public class UserContext {

    private static final ThreadLocal<UserInfoDTO> USER_THREAD_LOCAL = new TransmittableThreadLocal<>();

    /**
     * 设置用户至上下文
     *
     * @param user 用户详情信息
     */
    public static void setUser(UserInfoDTO user) {
        USER_THREAD_LOCAL.set(user);
    }

    /**
     * 根据request获取用户信息
     *
     * @return 授权用户
     */
    public static UserInfoDTO getCurrentUser() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String accessToken = request.getHeader(SecurityEnum.HEADER_TOKEN.getValue());
            return JWTUtil.parseJwtToken(accessToken);
        }
        return null;
    }

    /**
     * 获取上下文中用户 ID
     *
     * @return 用户 ID
     */
    public static String getUserId() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return Optional.ofNullable(userInfoDTO).map(UserInfoDTO::getUserId).orElse(null);
    }

    /**
     * 获取上下文中用户名称
     *
     * @return 用户名称
     */
    public static String getUsername() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return Optional.ofNullable(userInfoDTO).map(UserInfoDTO::getUsername).orElse(null);
    }

    /**
     * 获取上下文中用户真实姓名
     *
     * @return 用户真实姓名
     */
    public static String getRealName() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return Optional.ofNullable(userInfoDTO).map(UserInfoDTO::getRealName).orElse(null);
    }

    /**
     * 获取上下文中用户 Token
     *
     * @return 用户 Token
     */
    public static String getToken() {
        UserInfoDTO userInfoDTO = USER_THREAD_LOCAL.get();
        return Optional.ofNullable(userInfoDTO).map(UserInfoDTO::getToken).orElse(null);
    }


//    public static UserInfoDTO getAuthUser(String accessToken) {
//        try {
//            //获取token的信息
//            Claims claims
//                    = Jwts.parser()
//                    .setSigningKey(SecretKeyUtil.generalKeyByDecoders())
//                    .parseClaimsJws(accessToken).getBody();
//            //获取存储在claims中的用户信息
//            String json = claims.get(SecurityEnum.USER_CONTEXT.getValue()).toString();
//            return new Gson().fromJson(json, UserInfoDTO.class);
//        } catch (Exception e) {
//            return null;
//        }
//    }

    /**
     * 写入邀请人信息
     */
    public static void settingInviter(String memberId, SingletonCache cache) {
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //邀请人id
            String inviterId = request.getHeader(SecurityEnum.INVITER.getValue());
            if (StringUtils.isNotEmpty(inviterId)) {
                cache.put(CachePrefix.INVITER.getPrefix() + memberId, inviterId);
            }
        }
    }

    /**
     * 清理用户上下文
     */
    public static void removeUser() {
        USER_THREAD_LOCAL.remove();
    }
}
