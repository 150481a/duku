package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreMenu;
import org.duku.mall.framework.starter.common.modules.member.mapper.StoreMenuMapper;
import org.duku.mall.framework.starter.common.modules.member.service.ClerkService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreMenuRoleService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreMenuService;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreMenuVO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreUserMenuVO;
import org.duku.mall.framework.starter.common.modules.permission.entity.dto.MenuSearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StoreMenuServiceImpl extends ServiceImpl<StoreMenuMapper, StoreMenu> implements StoreMenuService {
    /**
     * 菜单角色
     */
    @Autowired
    private StoreMenuRoleService storeMenuRoleService;

    @Autowired
    private SingletonCache cache;

    /**
     * 店员
     */
    @Autowired
    private ClerkService clerkService;


    @Override
    public List<StoreMenuVO> findUserTree() {
        return List.of();
    }

    @Override
    public List<StoreMenu> findUserList(String userId, String clerkId) {
        return List.of();
    }

    @Override
    public List<StoreMenu> findByRoleIds(String roleIds) {
        return List.of();
    }

    @Override
    public List<StoreMenuVO> tree() {
        return List.of();
    }

    @Override
    public List<StoreMenu> searchList(MenuSearchParams menuSearchParams) {
        return List.of();
    }

    @Override
    public void deleteIds(List<String> ids) {

    }

    @Override
    public boolean saveOrUpdateMenu(StoreMenu storeMenu) {
        return false;
    }

    @Override
    public List<StoreUserMenuVO> getUserRoleMenu(String clerkId) {
        return List.of();
    }
}
