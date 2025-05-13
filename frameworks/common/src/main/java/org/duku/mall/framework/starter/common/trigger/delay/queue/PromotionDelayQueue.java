package org.duku.mall.framework.starter.common.trigger.delay.queue;

import org.duku.mall.framework.starter.common.trigger.delay.AbstractDelayQueueMachineFactory;
import org.springframework.stereotype.Component;

/**
 * 促销延迟队列
 */
@Component
public class PromotionDelayQueue extends AbstractDelayQueueMachineFactory {

    @Override
    public String setDelayQueueName() {
        return DelayQueueEnums.PROMOTION.name();
    }
}
