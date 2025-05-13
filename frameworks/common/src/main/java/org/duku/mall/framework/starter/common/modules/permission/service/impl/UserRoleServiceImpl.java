package org.duku.mall.framework.starter.common.modules.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.UserRole;
import org.duku.mall.framework.starter.common.modules.permission.mapper.UserRoleMapper;
import org.duku.mall.framework.starter.common.modules.permission.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
