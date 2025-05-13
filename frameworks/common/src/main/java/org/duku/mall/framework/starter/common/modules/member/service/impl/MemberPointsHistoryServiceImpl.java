package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.MemberPointsHistoryVO;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberPointsHistoryMapper;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberPointsHistory;
import org.duku.mall.framework.starter.common.modules.member.service.MemberPointsHistoryService;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberPointsHistoryServiceImpl extends ServiceImpl<MemberPointsHistoryMapper, MemberPointsHistory>     implements MemberPointsHistoryService {


    @Autowired
    private MemberService memberService;

    @Override
    public MemberPointsHistoryVO getMemberPointsHistoryVO(String memberId) {
        return null;
    }

    @Override
    public IPage<MemberPointsHistory> MemberPointsHistoryList(PageVO page, String memberId, String memberName) {
        return null;
    }
}
