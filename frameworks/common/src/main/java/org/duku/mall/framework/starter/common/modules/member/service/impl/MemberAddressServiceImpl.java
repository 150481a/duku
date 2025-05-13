package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberAddress;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberAddressMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberAddressService;

public class MemberAddressServiceImpl extends ServiceImpl <MemberAddressMapper, MemberAddress> implements MemberAddressService {
    @Override
    public IPage<MemberAddress> getAddressByMember(PageVO page, String memberId) {
        return null;
    }

    @Override
    public MemberAddress getMemberAddress(String id) {
        return null;
    }

    @Override
    public MemberAddress getDefaultMemberAddress() {
        return null;
    }

    @Override
    public MemberAddress saveMemberAddress(MemberAddress memberAddress) {
        return null;
    }

    @Override
    public MemberAddress updateMemberAddress(MemberAddress memberAddress) {
        return null;
    }

    @Override
    public boolean removeMemberAddress(String id) {
        return false;
    }
}
