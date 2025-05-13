package org.duku.mall.framework.starter.common.modules.payment.service.impl;

import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PaymentSuccessParam;
import org.duku.mall.framework.starter.common.modules.payment.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void success(PaymentSuccessParam paymentSuccessParams) {

    }

    @Override
    public void adminPaySuccess(PaymentSuccessParam paymentSuccessParams) {

    }
}
