package org.duku.mall.framework.starter.common.modules.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.DepartmentRole;
import org.duku.mall.framework.starter.common.modules.permission.mapper.DepartmentRoleMapper;
import org.duku.mall.framework.starter.common.modules.permission.service.DepartmentRoleService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentRoleServiceImpl extends ServiceImpl<DepartmentRoleMapper, DepartmentRole> implements DepartmentRoleService {
}
