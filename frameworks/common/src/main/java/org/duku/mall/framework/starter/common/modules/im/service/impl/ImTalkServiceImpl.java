package org.duku.mall.framework.starter.common.modules.im.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.ImTalk;
import org.duku.mall.framework.starter.common.modules.im.entity.params.IMTalkQueryParams;
import org.duku.mall.framework.starter.common.modules.im.entity.vo.ImTalkVO;
import org.duku.mall.framework.starter.common.modules.im.mapper.ImTalkMapper;
import org.duku.mall.framework.starter.common.modules.im.service.ImMessageService;
import org.duku.mall.framework.starter.common.modules.im.service.ImTalkService;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.duku.mall.framework.starter.common.modules.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ImTalkServiceImpl extends ServiceImpl<ImTalkMapper, ImTalk> implements ImTalkService {


    @Autowired
    private MemberService memberService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private ImMessageService imMessageService;

    @Override
    public ImTalk getTalkByUser(String userId1) {
        return null;
    }

    @Override
    public ImTalkVO getTalkByUserId(String userId) {
        return null;
    }

    @Override
    public void top(String id, Boolean top) {

    }

    @Override
    public void disable(String id) {

    }

    @Override
    public List<ImTalkVO> getUserTalkList(IMTalkQueryParams imTalkQueryParams) {
        return List.of();
    }

    @Override
    public List<ImTalkVO> getStoreTalkList(IMTalkQueryParams imTalkQueryParams) {
        return List.of();
    }
}
