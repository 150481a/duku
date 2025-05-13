package org.duku.mall.framework.starter.common.modules.message.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.StoreMessage;
import org.duku.mall.framework.starter.common.modules.message.entity.vo.StoreMessageQueryVO;
import org.duku.mall.framework.starter.common.modules.message.mapper.StoreMessageMapper;
import org.duku.mall.framework.starter.common.modules.message.service.StoreMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreMessageServiceImpl extends ServiceImpl <StoreMessageMapper, StoreMessage> implements StoreMessageService {
    @Override
    public boolean deleteByMessageId(String messageId) {
        return false;
    }

    @Override
    public IPage<StoreMessage> getPage(StoreMessageQueryVO storeMessageQueryVO, PageVO pageVO) {
        return null;
    }

    @Override
    public boolean save(List<StoreMessage> messages) {
        return false;
    }

    @Override
    public boolean editStatus(String status, String id) {
        return false;
    }
}
