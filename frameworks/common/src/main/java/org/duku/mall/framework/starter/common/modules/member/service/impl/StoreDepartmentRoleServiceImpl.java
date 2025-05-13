package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreDepartmentRole;
import org.duku.mall.framework.starter.common.modules.member.mapper.StoreDepartmentRoleMapper;
import org.duku.mall.framework.starter.common.modules.member.service.StoreDepartmentRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StoreDepartmentRoleServiceImpl extends ServiceImpl<StoreDepartmentRoleMapper, StoreDepartmentRole> implements StoreDepartmentRoleService {
    @Autowired
    private SingletonCache cache;

    @Override
    public List<StoreDepartmentRole> listByDepartmentId(String storeDepartmentId) {
        return List.of();
    }

    @Override
    public void updateByDepartmentId(String storeDepartmentId, List<StoreDepartmentRole> storeDepartmentRoles) {

    }

    @Override
    public void deleteByDepartment(List<String> ids) {

    }
}
