package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Payer {
    /**
     * 用户标识
     */
    private String openid;
    /**
     * 用户服务标识
     */
    private String sp_openid;
    /**
     * 用户子标识
     */
    private String sub_openid;
}
