package org.duku.mall.framework.starter.common.modules.payment.service;

import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PaymentSuccessParam;

public interface PaymentService {

    /**
     * 支付成功通知
     *
     * @param paymentSuccessParams 支付成功回调参数
     */
    void success(PaymentSuccessParam paymentSuccessParams);


    /**
     * 平台支付成功
     *
     * @param paymentSuccessParams 支付成功回调参数
     */
    void adminPaySuccess(PaymentSuccessParam paymentSuccessParams);
}
