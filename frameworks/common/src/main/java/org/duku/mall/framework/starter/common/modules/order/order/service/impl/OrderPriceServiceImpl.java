package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderPriceService;
import org.springframework.stereotype.Service;

@Service
public class OrderPriceServiceImpl implements OrderPriceService {
    @Override
    public Order updatePrice(String orderSn, Double orderPrice) {
        return null;
    }

    @Override
    public void adminPayOrder(String orderSn) {

    }
}
