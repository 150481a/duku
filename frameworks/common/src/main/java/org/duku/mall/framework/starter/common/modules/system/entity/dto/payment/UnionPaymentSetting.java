package org.duku.mall.framework.starter.common.modules.system.entity.dto.payment;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UnionPaymentSetting {


    /**
     * 商户号
     */
    private String unionPayMachId;
    /**
     * 密钥
     */
    private String unionPayKey;
    /**
     * 请求地址
     */
    private String unionPayServerUrl;
    /**
     * 交易请求地址
     */
    private String unionPayDomain;
    /**
     * 应用ID
     */
    private String unionPayAppId;
}
