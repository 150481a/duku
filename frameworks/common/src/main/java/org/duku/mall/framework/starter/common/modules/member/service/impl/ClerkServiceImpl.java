package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Clerk;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.ClerkAddDTO;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.ClerkEditDTO;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.ClerkQueryDTO;
import org.duku.mall.framework.starter.common.modules.member.mapper.ClerkMapper;
import org.duku.mall.framework.starter.common.modules.member.service.ClerkService;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreClerkRoleService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreDepartmentService;
import org.duku.mall.framework.starter.common.modules.member.service.StoreRoleService;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.ClerkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClerkServiceImpl extends ServiceImpl<ClerkMapper, Clerk> implements ClerkService {

    @Autowired
    private StoreRoleService storeRoleService;
    @Autowired
    private StoreDepartmentService storeDepartmentService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private StoreClerkRoleService storeClerkRoleService;
    @Autowired
    private SingletonCache cache;

    @Override
    public IPage<ClerkVO> clerkForPage(PageVO page, ClerkQueryDTO clerkQueryDTO) {
        return null;
    }

    @Override
    public ClerkVO get(String id) {
        return null;
    }

    @Override
    public Clerk updateClerk(ClerkEditDTO clerkEditDTO) {
        return null;
    }

    @Override
    public Clerk saveClerk(ClerkAddDTO clerkAddDTO) {
        return null;
    }

    @Override
    public Clerk getClerkByMemberId(String memberId) {
        return null;
    }

    @Override
    public void resetPassword(List<String> ids) {

    }

    @Override
    public void deleteClerk(List<String> ids) {

    }

    @Override
    public Member checkClerk(String mobile) {
        return null;
    }

    @Override
    public void disable(String id, Boolean status) {

    }
}
