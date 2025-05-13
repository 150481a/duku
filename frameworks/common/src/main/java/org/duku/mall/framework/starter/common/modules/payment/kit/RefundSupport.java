package org.duku.mall.framework.starter.common.modules.payment.kit;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.distributedid.toolkit.SnowflakeIdUtil;
import org.duku.mall.framework.starter.bases.ApplicationContextHolder;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderService;
import org.duku.mall.framework.starter.common.modules.order.order.service.StoreFlowService;
import org.duku.mall.framework.starter.common.modules.payment.entity.dos.RefundLog;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.PaymentMethodEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RefundSupport {

    /**
     * 店铺流水
     */
    @Autowired
    private StoreFlowService storeFlowService;
    /**
     * 订单
     */
    @Autowired
    private OrderService orderService;

    /**
     * 售后退款
     *
     * @param afterSale
     */
    public void refund(AfterSale afterSale) {
        Order order = orderService.getBySn(afterSale.getOrderSn());
        RefundLog refundLog = RefundLog.builder()
                .isRefund(false)
                .totalAmount(afterSale.getActualRefundPrice())
                .payPrice(afterSale.getActualRefundPrice())
                .memberId(afterSale.getMemberId())
                .paymentName(order.getPaymentMethod())
                .afterSaleNo(afterSale.getSn())
                .paymentReceivableNo(order.getReceivableNo())
                .outOrderNo("AF" + SnowflakeIdUtil.nextIdStr())
                .orderSn(afterSale.getOrderSn())
                .refundReason(afterSale.getReason())
                .build();
        PaymentMethodEnum paymentMethodEnum = PaymentMethodEnum.paymentNameOf(order.getPaymentMethod());
        Payment payment = (Payment) ApplicationContextHolder.getBean(paymentMethodEnum.getPlugin());
        payment.refund(refundLog);

        //记录退款流水
        storeFlowService.refundOrder(afterSale);
    }

    /**
     * 退款通知
     *
     * @param paymentMethodEnum 支付渠道
     */
    public void notify(PaymentMethodEnum paymentMethodEnum,
                       HttpServletRequest request) {

        //获取支付插件
        Payment payment = (Payment) ApplicationContextHolder.getBean(paymentMethodEnum.getPlugin());
        payment.refundNotify(request);
    }
}
