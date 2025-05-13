package org.duku.mall.framework.starter.common.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;

@Slf4j
public class RocketmqSendCallback implements SendCallback {
    @Override
    public void onSuccess(SendResult sendResult) {
        log.info("async onSuccess SendResult={}", sendResult);
    }

    @Override
    public void onException(Throwable throwable) {
        log.error("async onException Throwable", throwable);
    }
}
