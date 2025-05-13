package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreRole;

import java.util.List;

public interface StoreRoleService extends IService<StoreRole> {


    /**
     * 获取默认角色
     *
     * @param defaultRole
     * @return
     */
    List<StoreRole> findByDefaultRole(Boolean defaultRole);


    /**
     * 批量删除角色
     *
     * @param roleIds
     */
    void deleteRoles(List<String> roleIds);

    /**
     * 修改角色
     *
     * @param storeRole 店铺角色
     * @return
     */
    Boolean update(StoreRole storeRole);

    /**
     * 保存店铺角色
     *
     * @param storeRole 店铺角色
     * @return
     */
    Boolean saveStoreRole(StoreRole storeRole);

    /**
     * 当前店铺 根据角色id查询角色
     *
     * @param ids 角色id
     * @return
     */
    List<StoreRole> list(List<String> ids);
}
