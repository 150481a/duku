package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wallet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.convention.result.ResultMessage;
import org.duku.mall.framework.starter.common.common.utils.ResultUtil;
import org.duku.mall.framework.starter.common.modules.payment.entity.dos.RefundLog;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.CashierEnum;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.PaymentMethodEnum;
import org.duku.mall.framework.starter.common.modules.payment.kit.CashierSupport;
import org.duku.mall.framework.starter.common.modules.payment.kit.Payment;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PayParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PaymentSuccessParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.params.dto.CashierParam;
import org.duku.mall.framework.starter.common.modules.payment.service.PaymentService;
import org.duku.mall.framework.starter.common.modules.payment.service.RefundLogService;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dto.MemberWalletUpdateDTO;
import org.duku.mall.framework.starter.common.modules.wallet.entity.enums.DepositServiceTypeEnum;
import org.duku.mall.framework.starter.common.modules.wallet.service.MemberWalletService;
import org.duku.mall.framework.starter.user.core.UserContext;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WalletPlugin implements Payment {

    /**
     * 支付日志
     */
    @Autowired
    private PaymentService paymentService;
    /**
     * 退款日志
     */
    @Autowired
    private RefundLogService refundLogService;
    /**
     * 会员余额
     */
    @Autowired
    private MemberWalletService memberWalletService;
    /**
     * 收银台
     */
    @Autowired
    private CashierSupport cashierSupport;

    @Autowired
    private RedissonClient redisson;

    @Override
    public ResultMessage<Object> h5pay(HttpServletRequest request, HttpServletResponse response, PayParam payParam) {
        savePaymentLog(payParam);
        return ResultUtil.success(ResultCode.PAY_SUCCESS);
    }

    @Override
    public ResultMessage<Object> jsApiPay(HttpServletRequest request, PayParam payParam) {
        savePaymentLog(payParam);
        return ResultUtil.success(ResultCode.PAY_SUCCESS);
    }

    @Override
    public ResultMessage<Object> appPay(HttpServletRequest request, PayParam payParam) {
        savePaymentLog(payParam);
        return ResultUtil.success(ResultCode.PAY_SUCCESS);
    }

    @Override
    public ResultMessage<Object> nativePay(HttpServletRequest request, PayParam payParam) {
        if (payParam.getOrderType().equals(CashierEnum.RECHARGE.name())) {
            throw new ServiceException(ResultCode.CAN_NOT_RECHARGE_WALLET);
        }
        savePaymentLog(payParam);
        return ResultUtil.success(ResultCode.PAY_SUCCESS);
    }

    @Override
    public ResultMessage<Object> mpPay(HttpServletRequest request, PayParam payParam) {

        savePaymentLog(payParam);
        return ResultUtil.success(ResultCode.PAY_SUCCESS);
    }

    /**
     * 保存支付日志
     *
     * @param payParam 支付参数
     */
    private void savePaymentLog(PayParam payParam) {
        //同一个会员如果在不同的客户端使用预存款支付，会存在同时支付，无法保证预存款的正确性，所以对会员加锁
        RLock lock = redisson.getLock(UserContext.getCurrentUser().getUserId() + "");
        lock.lock();
        try {
            //获取支付收银参数
            CashierParam cashierParam = cashierSupport.cashierParam(payParam);
            this.callBack(payParam, cashierParam);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void refund(RefundLog refundLog) {
        try {
            memberWalletService.increase(new MemberWalletUpdateDTO(refundLog.getTotalAmount(),
                    refundLog.getMemberId(),
                    "订单[" + refundLog.getOrderSn() + "]，售后单[" + refundLog.getAfterSaleNo() + "]，退还金额[" + refundLog.getTotalAmount() + "]",
                    DepositServiceTypeEnum.WALLET_REFUND.name()));
            refundLog.setIsRefund(true);
            refundLogService.save(refundLog);
        } catch (Exception e) {
            log.error("退款失败", e);
        }
    }

    /**
     * 支付订单
     *
     * @param payParam     支付参数
     * @param cashierParam 收银台参数
     */
    public void callBack(PayParam payParam, CashierParam cashierParam) {

        //支付信息
        try {
            if (UserContext.getCurrentUser() == null) {
                throw new ServiceException(ResultCode.USER_NOT_LOGIN);
            }
            boolean result = memberWalletService.reduce(new MemberWalletUpdateDTO(
                            cashierParam.getPrice(),
                            UserContext.getCurrentUser().getUserId(),
                            "订单[" + cashierParam.getOrderSns() + "]支付金额[" + cashierParam.getPrice() + "]",
                            DepositServiceTypeEnum.WALLET_PAY.name()
                    )
            );
            if (result) {
                try {
                    PaymentSuccessParam paymentSuccessParams = new PaymentSuccessParam(
                            PaymentMethodEnum.WALLET.name(),
                            "",
                            cashierParam.getPrice(),
                            payParam
                    );

                    paymentService.success(paymentSuccessParams);
                    log.info("支付回调通知：余额支付：{}", payParam);
                } catch (ServiceException e) {
                    //业务异常，则支付手动回滚
                    memberWalletService.increase(new MemberWalletUpdateDTO(
                            cashierParam.getPrice(),
                            UserContext.getCurrentUser().getUserId(),
                            "订单[" + cashierParam.getOrderSns() + "]支付异常，余额返还[" + cashierParam.getPrice() + "]",
                            DepositServiceTypeEnum.WALLET_REFUND.name())
                    );
                    throw e;
                }
            } else {
                throw new ServiceException(ResultCode.WALLET_INSUFFICIENT);
            }
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            log.info("余额支付异常", e);
            throw new ServiceException(ResultCode.WALLET_INSUFFICIENT);
        }

    }
}
