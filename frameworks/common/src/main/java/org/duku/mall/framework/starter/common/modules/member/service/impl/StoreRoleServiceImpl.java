package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreRole;
import org.duku.mall.framework.starter.common.modules.member.mapper.StoreRoleMapper;
import org.duku.mall.framework.starter.common.modules.member.service.StoreClerkRoleService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreDepartmentRoleService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreMenuRoleService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class StoreRoleServiceImpl extends ServiceImpl<StoreRoleMapper, StoreRole> implements StoreRoleService {

    /**
     * 部门角色
     */
    @Autowired
    private StoreDepartmentRoleService storeDepartmentRoleService;
    /**
     * 用户权限
     */
    @Autowired
    private StoreClerkRoleService storeClerkRoleService;

    @Autowired
    private StoreMenuRoleService storeMenuRoleService;

    @Autowired
    private SingletonCache cache;

    @Override
    public List<StoreRole> findByDefaultRole(Boolean defaultRole) {
        return List.of();
    }

    @Override
    public void deleteRoles(List<String> roleIds) {

    }

    @Override
    public Boolean update(StoreRole storeRole) {
        return null;
    }

    @Override
    public Boolean saveStoreRole(StoreRole storeRole) {
        return null;
    }

    @Override
    public List<StoreRole> list(List<String> ids) {
        return List.of();
    }
}
