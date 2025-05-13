package org.duku.mall.framework.starter.common.modules.permission.service.impl;

import co.elastic.clients.elasticsearch.security.RoleMapping;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.Role;
import org.duku.mall.framework.starter.common.modules.permission.mapper.RoleMapper;
import org.duku.mall.framework.starter.common.modules.permission.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
