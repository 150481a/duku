package org.duku.mall.framework.starter.common.modules.message.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.MemberMessage;
import org.duku.mall.framework.starter.common.modules.message.entity.vo.MemberMessageQueryVO;
import org.duku.mall.framework.starter.common.modules.message.mapper.MemberMessageMapper;
import org.duku.mall.framework.starter.common.modules.message.service.MemberMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberMessageServiceImpl extends ServiceImpl<MemberMessageMapper, MemberMessage> implements MemberMessageService {
    @Override
    public IPage<MemberMessage> getPage(MemberMessageQueryVO memberMessageQueryVO, PageVO pageVO) {
        return null;
    }

    @Override
    public Boolean editStatus(String status, String messageId) {
        return null;
    }

    @Override
    public Boolean deleteMessage(String messageId) {
        return null;
    }

    @Override
    public boolean save(List<MemberMessage> messages) {
        return false;
    }
}
