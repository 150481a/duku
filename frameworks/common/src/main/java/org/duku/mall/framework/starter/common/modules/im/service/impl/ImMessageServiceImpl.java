package org.duku.mall.framework.starter.common.modules.im.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.ImMessage;
import org.duku.mall.framework.starter.common.modules.im.entity.params.MessageQueryParams;
import org.duku.mall.framework.starter.common.modules.im.mapper.ImMessageMapper;
import org.duku.mall.framework.starter.common.modules.im.service.ImMessageService;
import org.duku.mall.framework.starter.common.modules.im.service.ImTalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ImMessageServiceImpl extends ServiceImpl <ImMessageMapper, ImMessage> implements ImMessageService {

    @Autowired
    private ImTalkService imTalkService;

    @Override
    public void read(String talkId, String accessToken) {

    }

    @Override
    public List<ImMessage> unReadMessages(String accessToken) {
        return List.of();
    }

    @Override
    public List<ImMessage> historyMessage(String accessToken, String to) {
        return List.of();
    }

    @Override
    public Boolean hasNewMessage(String accessToken) {
        return null;
    }

    @Override
    public List<ImMessage> getList(MessageQueryParams messageQueryParams) {
        return List.of();
    }

    @Override
    public Long unreadMessageCount() {
        return 0L;
    }

    @Override
    public void cleanUnreadMessage() {

    }
}
