package org.duku.mall.framework.starter.common.modules.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.Menu;
import org.duku.mall.framework.starter.common.modules.permission.entity.dto.MenuSearchParams;
import org.duku.mall.framework.starter.common.modules.permission.entity.vo.MenuVO;
import org.duku.mall.framework.starter.common.modules.permission.entity.vo.UserMenuVO;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames = "{menu}")
public interface MenuService extends IService<Menu> {

    /**
     * 通过用户的菜单权限
     *
     * @return
     */
    List<MenuVO> findUserTree();

    /**
     * 通过用户id获取
     *
     * @param userId
     * @return
     */
    List<Menu> findUserList(String userId);


    /**
     * 根据角色id获取菜单集合
     *
     * @param roleIds
     * @return
     */
    List<Menu> findByRoleIds(String roleIds);

    /**
     * 树形结构
     *
     * @return
     */
    List<MenuVO> tree();

    /**
     * 查询列表
     *
     * @param menuSearchParams
     * @return
     */
    List<Menu> searchList(MenuSearchParams menuSearchParams);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteIds(List<String> ids);

    /**
     * 添加更新菜单
     *
     * @param menu 菜单数据
     * @return 是否成功
     */
    boolean saveOrUpdateMenu(Menu menu);

    /**
     * 根据角色集合获取拥有的菜单具体权限
     *
     * @param userId
     * @return
     */
    List<UserMenuVO> findAllMenu(String userId);
}
