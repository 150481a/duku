package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreMenuRole;
import org.duku.mall.framework.starter.common.modules.member.mapper.StoreMenuRoleMapper;
import org.duku.mall.framework.starter.common.modules.member.service.StoreMenuRoleService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreMenuService;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreUserMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class StoreMenuRoleServiceImpl extends ServiceImpl<StoreMenuRoleMapper, StoreMenuRole>  implements StoreMenuRoleService {
    /**
     * 菜单
     */
    @Autowired
    private StoreMenuService storeMenuService;

    @Autowired
    private SingletonCache<Object> cache;

    @Override
    public List<StoreMenuRole> findByRoleId(String roleId) {
        return List.of();
    }

    @Override
    public List<StoreUserMenuVO> findAllMenu(String clerkId, String memberId) {
        return List.of();
    }

    @Override
    public void updateRoleMenu(String roleId, List<StoreMenuRole> roleMenus) {

    }

    @Override
    public void delete(String roleId) {

    }

    @Override
    public void delete(List<String> roleId) {

    }
}
