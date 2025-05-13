package org.duku.mall.framework.starter.common.modules.order.order.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.OrderStatusEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMessage {

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 新状态
     *
     * @see OrderStatusEnum
     */
    private OrderStatusEnum newStatus;

    /**
     * 支付方式
     */
    private String paymentMethod;
}
