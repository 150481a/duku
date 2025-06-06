package org.duku.mall.framework.starter.common.modules.payment.kit;

import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.convention.result.ResultMessage;
import org.duku.mall.framework.starter.bases.ApplicationContextHolder;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.PaymentClientEnum;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.PaymentMethodEnum;
import org.duku.mall.framework.starter.common.modules.payment.kit.params.dto.CashierParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PayParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.params.service.CashierExecute;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Setting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.OrderSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.PaymentSupportSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.dto.PaymentSupportItem;
import org.duku.mall.framework.starter.common.modules.system.entity.enums.SettingEnum;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dos.MemberWithdrawApply;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dto.TransferResultDTO;
import org.duku.mall.framework.starter.common.modules.wallet.service.MemberWalletService;
import org.duku.mall.framework.starter.user.core.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CashierSupport {

    /**
     * 收银台
     */
    @Autowired
    private List<CashierExecute> cashierExecuteList;
    /**
     * 预存款
     */
    @Autowired
    private MemberWalletService memberWalletService;
    /**
     * 配置
     */
    @Autowired
    private SettingService settingService;

    /**
     * 支付
     *
     * @param paymentMethodEnum 支付渠道枚举
     * @param paymentClientEnum 支付方式枚举
     * @return 支付消息
     */
    public ResultMessage<Object> payment(PaymentMethodEnum paymentMethodEnum, PaymentClientEnum paymentClientEnum,
                                         HttpServletRequest request, HttpServletResponse response,
                                         PayParam payParam) {
        if (paymentClientEnum == null || paymentMethodEnum == null) {
            throw new ServiceException(ResultCode.PAY_NOT_SUPPORT);
        }
        //获取支付插件
        Payment payment = (Payment) ApplicationContextHolder.getBean(paymentMethodEnum.getPlugin());
        log.info("支付请求：客户端：{},支付类型：{},请求：{}", paymentClientEnum.name(), paymentMethodEnum.name(), payParam.toString());

        //支付方式调用
        switch (paymentClientEnum) {
            case H5:
                return payment.h5pay(request, response, payParam);
            case APP:
                return payment.appPay(request, payParam);
            case JSAPI:
                return payment.jsApiPay(request, payParam);
            case NATIVE:
                return payment.nativePay(request, payParam);
            case MP:
                return payment.mpPay(request, payParam);
            default:
                return null;
        }
    }

    /**
     * 支付 支持的支付方式
     *
     * @param client 客户端类型
     * @return 支持的支付方式
     */
    public List<String> support(String client) {

        ClientTypeEnum clientTypeEnum;
        try {
            clientTypeEnum = ClientTypeEnum.valueOf(client);
        } catch (IllegalArgumentException e) {
            throw new ServiceException(ResultCode.PAY_CLIENT_TYPE_ERROR);
        }
        //支付方式 循环获取
        Setting setting = settingService.get(SettingEnum.PAYMENT_SUPPORT.name());
        PaymentSupportSetting paymentSupportSetting = JSONUtil.toBean(setting.getSettingValue(), PaymentSupportSetting.class);
        for (PaymentSupportItem paymentSupportItem : paymentSupportSetting.getPaymentSupportItems()) {
            if (paymentSupportItem.getClient().equals(clientTypeEnum.name())) {
                return paymentSupportItem.getSupports();
            }
        }
        throw new ServiceException(ResultCode.PAY_NOT_SUPPORT);
    }

    /**
     * 支付回调
     *
     * @param paymentMethodEnum 支付渠道枚举
     * @return 回调消息
     */
    public void callback(PaymentMethodEnum paymentMethodEnum,
                         HttpServletRequest request) {

        log.info("支付回调：支付类型：{}", paymentMethodEnum.name());

        //获取支付插件
        Payment payment = (Payment) ApplicationContextHolder.getBean(paymentMethodEnum.getPlugin());
        payment.callBack(request);
    }

    /**
     * 支付通知
     *
     * @param paymentMethodEnum 支付渠道
     */
    public void notify(PaymentMethodEnum paymentMethodEnum,
                       HttpServletRequest request) {

        log.info("支付异步通知：支付类型：{}", paymentMethodEnum.name());

        //获取支付插件
        Payment payment = (Payment) ApplicationContextHolder.getBean(paymentMethodEnum.getPlugin());
        payment.notify(request);
    }

    /**
     * 用户提现
     *
     * @param paymentMethodEnum   支付渠道
     * @param memberWithdrawApply 用户提现申请
     */
    public TransferResultDTO transfer(PaymentMethodEnum paymentMethodEnum, MemberWithdrawApply memberWithdrawApply) {
        Payment payment = (Payment) ApplicationContextHolder.getBean(paymentMethodEnum.getPlugin());
        return payment.transfer(memberWithdrawApply);
    }

    /**
     * 获取收银台参数
     *
     * @param payParam 支付请求参数
     * @return 收银台参数
     */
    public CashierParam cashierParam(PayParam payParam) {
        for (CashierExecute paramInterface : cashierExecuteList) {
            CashierParam cashierParam = paramInterface.getPaymentParams(payParam);
            //如果为空，则表示收银台参数初始化不匹配，继续匹配下一条
            if (cashierParam == null) {
                continue;
            }
            //如果订单不需要付款，则抛出异常，直接返回
            if (cashierParam.getPrice() <= 0) {
                throw new ServiceException(ResultCode.PAY_UN_WANTED);
            }
            cashierParam.setSupport(support(payParam.getClientType()));
            cashierParam.setWalletValue(memberWalletService.getMemberWallet(UserContext.getCurrentUser().getUserId()).getMemberWallet());
            OrderSetting orderSetting = JSONUtil.toBean(settingService.get(SettingEnum.ORDER_SETTING.name()).getSettingValue(), OrderSetting.class);
            Integer minute = orderSetting.getAutoCancel();
            cashierParam.setAutoCancel(cashierParam.getCreateTime().getTime() + minute * 1000 * 60);
            return cashierParam;
        }
        log.error("错误的支付请求:{}", payParam.toString());
        throw new ServiceException(ResultCode.PAY_CASHIER_ERROR);
    }


    /**
     * 支付结果
     *
     * @param payParam
     * @return
     */
    public Boolean paymentResult(PayParam payParam) {
        for (CashierExecute cashierExecute : cashierExecuteList) {
            if (cashierExecute.cashierEnum().name().equals(payParam.getOrderType())) {
                return cashierExecute.paymentResult(payParam);
            }
        }
        return false;
    }
}
