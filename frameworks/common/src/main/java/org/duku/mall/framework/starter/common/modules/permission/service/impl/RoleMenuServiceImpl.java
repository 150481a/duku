package org.duku.mall.framework.starter.common.modules.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.RoleMenu;
import org.duku.mall.framework.starter.common.modules.permission.mapper.RoleMenuMapper;
import org.duku.mall.framework.starter.common.modules.permission.service.RoleMenuService;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
}
