package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreClerkRole;

import java.util.List;

public interface StoreClerkRoleService extends IService<StoreClerkRole> {

    /**
     * 根据用户查看拥有的角色
     *
     * @param clerkId 店员id
     * @return
     */
    List<StoreClerkRole> listByUserId(String clerkId);

    /**
     * 根据店员id查看角色
     *
     * @param clerkId 店员id
     * @return
     */
    List<String> listId(String clerkId);

    /**
     * 更新用户拥有的角色
     *
     * @param clerkId         店员id
     * @param storeClerkRoles 角色权限
     */
    void updateClerkRole(String clerkId, List<StoreClerkRole> storeClerkRoles);


}
