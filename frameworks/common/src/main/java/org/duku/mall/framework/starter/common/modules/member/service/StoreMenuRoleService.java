package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreMenuRole;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreUserMenuVO;

import java.util.List;

public interface StoreMenuRoleService extends IService<StoreMenuRole> {

    /**
     * 通过角色获取菜单权限列表
     *
     * @param roleId
     * @return
     */
    List<StoreMenuRole> findByRoleId(String roleId);


    /**
     * 根据角色集合获取拥有的菜单具体权限
     *
     * @param clerkId
     * @return
     */
    List<StoreUserMenuVO> findAllMenu(String clerkId, String memberId);


    /**
     * 更新某角色拥有到菜单
     *
     * @param roleId    角色id
     * @param roleMenus
     */
    void updateRoleMenu(String roleId, List<StoreMenuRole> roleMenus);

    /**
     * 根据角色id 删除数据
     *
     * @param roleId
     */
    void delete(String roleId);

    /**
     * 根据角色id 删除数据
     *
     * @param roleId
     */
    void delete(List<String> roleId);
}
