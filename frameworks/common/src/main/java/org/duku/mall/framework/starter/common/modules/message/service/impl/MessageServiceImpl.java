package org.duku.mall.framework.starter.common.modules.message.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.message.entity.vo.MessageVO;
import org.duku.mall.framework.starter.common.modules.message.mapper.MessageMapper;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.Message;
import org.duku.mall.framework.starter.common.modules.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;

    @Override
    public IPage<Message> getPage(MessageVO messageVO, PageVO pageVO) {
        return null;
    }

    @Override
    public Boolean sendMessage(Message message) {
        return null;
    }

    @Override
    public Boolean deleteMessage(String id) {
        return null;
    }
}
