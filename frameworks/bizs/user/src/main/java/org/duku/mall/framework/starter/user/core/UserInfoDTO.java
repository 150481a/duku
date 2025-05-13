package org.duku.mall.framework.starter.user.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.convention.enums.UserEnums;

import java.io.Serializable;

/**
 * 用户信息 DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 582441893336003319L;
    /**
     * 用户 ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户 Token
     */
    private String token;


    /**
     * 头像
     */
    private String face;

    /**
     * 长期有效（用于手机app登录场景或者信任场景等）
     */
    private Boolean longTerm = false;

    /**
     * @see UserEnums
     * 角色
     */
    private UserEnums role;

    /**
     * 如果角色是商家，则存在此店铺id字段
     * storeId
     */
    private String storeId;
    /**
     * 如果角色是商家，则存在此店铺id字段
     * clerkId
     */
    private String clerkId;

    /**
     * 如果角色是商家，则存在此店铺名称字段
     * storeName
     */
    private String storeName;

    /**
     * 是否是超级管理员
     */
    private Boolean isSuper = false;

    /**
     * 租户id
     */
    private String tenantId;


    public UserInfoDTO(String username, String userId, String nickName, String face, UserEnums role) {
        this.username = username;
        this.face = face;
        this.userId = userId;
        this.role = role;
        this.nickName = nickName;
    }
}
