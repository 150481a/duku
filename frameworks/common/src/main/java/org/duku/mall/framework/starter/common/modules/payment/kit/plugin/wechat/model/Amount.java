package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Amount {


    /**
     * 总金额
     */
    private Integer total;

    /**
     * 货币类型
     */
    private String currency = "CNY";

    /**
     * 退款金额
     */
    private Integer refund;
}
