package org.duku.mall.framework.starter.common.modules.message.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.NoticeMessage;
import org.duku.mall.framework.starter.common.modules.message.entity.dto.NoticeMessageDTO;
import org.duku.mall.framework.starter.common.modules.message.mapper.NoticeMessageMapper;
import org.duku.mall.framework.starter.common.modules.message.service.MemberMessageService;
import org.duku.mall.framework.starter.common.modules.message.service.NoticeMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeMessageServiceImpl extends ServiceImpl<NoticeMessageMapper, NoticeMessage> implements NoticeMessageService {

    @Autowired
    private MemberMessageService memberMessageService;

    @Override
    public IPage<NoticeMessage> getMessageTemplate(PageVO pageVO, String type) {
        return null;
    }

    @Override
    public void noticeMessage(NoticeMessageDTO noticeMessageDTO) {

    }
}
