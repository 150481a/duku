package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreMenu;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreMenuVO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreUserMenuVO;
import org.duku.mall.framework.starter.common.modules.permission.entity.dto.MenuSearchParams;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames = "{store_menu}")
public interface StoreMenuService extends IService<StoreMenu> {


    /**
     * 通过用户的菜单权限
     *
     * @return
     */
    List<StoreMenuVO> findUserTree();

    /**
     * 通过用户id获取
     *
     * @param userId
     * @return
     */
    List<StoreMenu> findUserList(String userId, String clerkId);


    /**
     * 根据角色id获取菜单集合
     *
     * @param roleIds
     * @return
     */
    List<StoreMenu> findByRoleIds(String roleIds);

    /**
     * 树形结构
     *
     * @return
     */
    List<StoreMenuVO> tree();

    /**
     * 查询列表
     *
     * @param menuSearchParams
     * @return
     */
    List<StoreMenu> searchList(MenuSearchParams menuSearchParams);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteIds(List<String> ids);

    /**
     * 添加更新菜单
     *
     * @param storeMenu 菜单数据
     * @return 是否成功
     */
    boolean saveOrUpdateMenu(StoreMenu storeMenu);

    List<StoreUserMenuVO> getUserRoleMenu(String clerkId);
}
