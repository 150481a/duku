package org.duku.mall.frameworks.starter.common.trigger.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 拼团订单延时任务信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PintuanOrderMessage {

    /**
     * 拼团活动id
     */
    private String pintuanId;

    /**
     * 父拼团订单sn
     */
    private String orderSn;
}
