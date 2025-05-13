package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreDepartment;
import org.duku.mall.framework.starter.common.modules.member.mapper.StoreDepartmentMapper;
import org.duku.mall.framework.starter.common.modules.member.service.ClerkService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreDepartmentRoleService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreDepartmentService;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreDepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class StoreDepartmentServiceImpl extends ServiceImpl<StoreDepartmentMapper, StoreDepartment> implements StoreDepartmentService {

    @Autowired
    private StoreDepartmentRoleService storeDepartmentRoleService;

    @Autowired
    private ClerkService clerkService;

    @Override
    public List<StoreDepartmentVO> tree(QueryWrapper<StoreDepartment> initWrapper) {
        return List.of();
    }

    @Override
    public void deleteByIds(List<String> ids) {

    }

    @Override
    public Boolean update(StoreDepartment storeDepartment) {
        return null;
    }
}
