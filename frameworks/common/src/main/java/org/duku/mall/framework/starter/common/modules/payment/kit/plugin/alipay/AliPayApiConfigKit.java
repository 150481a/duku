package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.alipay;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.bases.ApplicationContextHolder;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Setting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.AlipayPaymentSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.enums.SettingEnum;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;

import java.util.Date;

public class AliPayApiConfigKit {

    /**
     * 支付配置
     */
    static DefaultAlipayClient defaultAlipayClient;

    /**
     * 下次刷新时间
     */
    static Date nextRebuildDate;

    /**
     * 间隔时间
     */
    static Long refreshInterval = 1000 * 60 * 3L;

    /**
     * 获取支付宝支付参数
     *
     * @return
     * @throws AlipayApiException
     */
    public static synchronized DefaultAlipayClient getAliPayApiConfig() throws AlipayApiException {
        Date date = new Date();
        //如果过期，则重新构建
        if (nextRebuildDate == null || date.after(nextRebuildDate)) {
            return rebuild();
        }
        return defaultAlipayClient;
    }

    static DefaultAlipayClient rebuild() throws AlipayApiException {
        AlipayPaymentSetting setting;
        try {
            SettingService settingService = (SettingService) ApplicationContextHolder.getBean("settingServiceImpl");
            Setting systemSetting = settingService.get(SettingEnum.ALIPAY_PAYMENT.name());
            setting = JSONUtil.toBean(systemSetting.getSettingValue(), AlipayPaymentSetting.class);
        } catch (Exception e) {
            throw new ServiceException(ResultCode.PAY_NOT_SUPPORT);
        }
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        certAlipayRequest.setServerUrl("https://openapi.alipay.com/gateway.do");
        certAlipayRequest.setFormat("json");
        certAlipayRequest.setCharset("utf-8");
        certAlipayRequest.setSignType("RSA2");
        certAlipayRequest.setAppId(setting.getAppId());
        certAlipayRequest.setPrivateKey(setting.getPrivateKey());
        certAlipayRequest.setCertPath(setting.getCertPath());
        certAlipayRequest.setAlipayPublicCertPath(setting.getAlipayPublicCertPath());
        certAlipayRequest.setRootCertPath(setting.getRootCertPath());
        defaultAlipayClient = new DefaultAlipayClient(certAlipayRequest);
        nextRebuildDate = DateUtil.date(System.currentTimeMillis()+ refreshInterval);
        return defaultAlipayClient;
    }
}
