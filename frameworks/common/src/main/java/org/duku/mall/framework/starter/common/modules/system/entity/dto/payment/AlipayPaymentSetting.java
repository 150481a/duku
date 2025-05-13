package org.duku.mall.framework.starter.common.modules.system.entity.dto.payment;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AlipayPaymentSetting {

    /**
     * 应用id
     */
    private String appId;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 应用证书
     */
    private String certPath;

    /**
     * 支付宝公钥
     */
    private String alipayPublicCertPath;

    /**
     * 支付宝根证书
     */
    private String rootCertPath;

    /**
     * 回调API地址
     */
    private String callbackUrl;
}
