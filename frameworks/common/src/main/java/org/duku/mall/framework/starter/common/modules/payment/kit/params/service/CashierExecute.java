package org.duku.mall.framework.starter.common.modules.payment.kit.params.service;

import org.duku.mall.framework.starter.common.modules.payment.entity.enums.CashierEnum;
import org.duku.mall.framework.starter.common.modules.payment.kit.params.dto.CashierParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PayParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PaymentSuccessParam;

public interface CashierExecute {
    /**
     * 获取支付参数
     *
     * @param payParam 收银台支付参数
     * @return 收银台所需支付参数
     */
    CashierParam getPaymentParams(PayParam payParam);

    /**
     * 支付成功
     *
     * @param paymentSuccessParam 支付回调
     */
    void paymentSuccess(PaymentSuccessParam paymentSuccessParam);

    /**
     * 支付结果查询
     *
     * @param payParam
     * @return
     */
    Boolean paymentResult(PayParam payParam);

    /**
     * 服务的枚举类型
     *
     * @return
     */
    CashierEnum cashierEnum();
}
