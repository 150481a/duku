package org.duku.mall.framework.starter.common.modules.order.order.service;

import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;

public interface OrderPriceService {
    /**
     * 价格修改
     * 日志功能内部实现
     *
     * @param orderSn    订单编号
     * @param orderPrice 订单价格
     * @return 订单
     */
    Order updatePrice(String orderSn, Double orderPrice);

    /**
     * 管理员订单付款
     *
     * @param orderSn 订单编号
     */
    void adminPayOrder(String orderSn);
}
