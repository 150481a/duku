package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.bank;

import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.common.modules.payment.entity.dos.RefundLog;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.PaymentMethodEnum;
import org.duku.mall.framework.starter.common.modules.payment.kit.Payment;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PayParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PaymentSuccessParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.params.dto.CashierParam;
import org.duku.mall.framework.starter.common.modules.payment.service.PaymentService;
import org.duku.mall.framework.starter.common.modules.payment.service.RefundLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BankTransferPlugin implements Payment {

    /**
     * 退款日志
     */
    @Autowired
    private RefundLogService refundLogService;
    /**
     * 支付日志
     */
    @Autowired
    private PaymentService paymentService;

    @Override
    public void refund(RefundLog refundLog) {
        try {
            refundLog.setIsRefund(true);
            refundLogService.save(refundLog);
        } catch (Exception e) {
            log.error("线下收款错误",e);
        }
    }

    /**
     * 支付订单
     *
     * @param order 订单
     */
    public void callBack(Order order) {

        //收银参数
        CashierParam cashierParam = new CashierParam();
        cashierParam.setPrice(order.getFlowPrice());
        //支付参数
        PayParam payParam = new PayParam();
        payParam.setOrderType("ORDER");
        payParam.setSn(order.getSn());
        payParam.setClientType(ClientTypeEnum.PC.name());

        PaymentSuccessParam paymentSuccessParams = new PaymentSuccessParam(
                PaymentMethodEnum.BANK_TRANSFER.name(),
                "",
                order.getFlowPrice(),
                payParam
        );

        //记录支付日志
        paymentService.adminPaySuccess(paymentSuccessParams);
        log.info("支付回调通知：线上支付：{}", payParam);
    }
}
