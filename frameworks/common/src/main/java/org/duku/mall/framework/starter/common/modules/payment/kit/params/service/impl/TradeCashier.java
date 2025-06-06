package org.duku.mall.framework.starter.common.modules.payment.kit.params.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderService;
import org.duku.mall.framework.starter.common.modules.order.order.service.TradeService;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.CashierEnum;
import org.duku.mall.framework.starter.common.modules.payment.kit.params.dto.CashierParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PayParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PaymentSuccessParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.params.service.CashierExecute;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TradeCashier implements CashierExecute {

    /**
     * 交易
     */
    @Autowired
    private TradeService tradeService;
    /**
     * 订单
     */
    @Autowired
    private OrderService orderService;
    /**
     * 设置
     */
    @Autowired
    private SettingService settingService;

    @Override
    public CashierParam getPaymentParams(PayParam payParam) {
        return null;
    }

    @Override
    public void paymentSuccess(PaymentSuccessParam paymentSuccessParam) {

    }

    @Override
    public Boolean paymentResult(PayParam payParam) {
        return null;
    }

    @Override
    public CashierEnum cashierEnum() {
        return null;
    }
}
