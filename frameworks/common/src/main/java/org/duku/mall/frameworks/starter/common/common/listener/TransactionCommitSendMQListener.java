package org.duku.mall.frameworks.starter.common.common.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.frameworks.starter.common.common.event.TransactionCommitSendMQEvent;
import org.duku.mall.frameworks.starter.common.rocketmq.RocketmqSendCallbackBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * MQ事物提交后发送消息监听器
 */
@Component
@Slf4j
public class TransactionCommitSendMQListener {

    /**
     * rocketMq
     */
    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void send(TransactionCommitSendMQEvent event) {
        log.info("事务提交，发送mq信息!{}", event);
        String destination = event.getTopic() + ":" + event.getTag();
        //发送订单变更mq消息
        rocketMQTemplate.asyncSend(destination, event.getMessage(), RocketmqSendCallbackBuilder.commonCallback());
    }
}
