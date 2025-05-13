package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreClerkRole;
import org.duku.mall.framework.starter.common.modules.member.mapper.StoreClerkRoleMapper;
import org.duku.mall.framework.starter.common.modules.member.service.StoreClerkRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class StoreClerkRoleServiceImpl extends ServiceImpl<StoreClerkRoleMapper, StoreClerkRole> implements StoreClerkRoleService {
    @Override
    public List<StoreClerkRole> listByUserId(String clerkId) {
        return List.of();
    }

    @Override
    public List<String> listId(String clerkId) {
        return List.of();
    }

    @Override
    public void updateClerkRole(String clerkId, List<StoreClerkRole> storeClerkRoles) {

    }
}
