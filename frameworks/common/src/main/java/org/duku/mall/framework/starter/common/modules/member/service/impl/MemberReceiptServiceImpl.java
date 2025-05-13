package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberReceipt;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.MemberReceiptAddVO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.MemberReceiptVO;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberReceiptMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberReceiptService;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberReceiptServiceImpl extends ServiceImpl <MemberReceiptMapper, MemberReceipt> implements MemberReceiptService {

    @Autowired
    private MemberService memberService;

    @Override
    public IPage<MemberReceipt> getPage(MemberReceiptVO memberReceiptVO, PageVO pageVO) {
        return null;
    }

    @Override
    public Boolean addMemberReceipt(MemberReceiptAddVO memberReceiptAddVO, String memberId) {
        return null;
    }

    @Override
    public Boolean editMemberReceipt(MemberReceiptAddVO memberReceiptAddVO, String memberId) {
        return null;
    }

    @Override
    public Boolean deleteMemberReceipt(String id) {
        return null;
    }
}
