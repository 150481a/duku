package org.duku.mall.framework.starter.common.modules.payment.kit.dto;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PayParam {

    @NotNull
    @ApiModelProperty(value = "交易类型", allowableValues = "TRADE,ORDER,RECHARGE")
    private String orderType;

    @NotNull
    @ApiModelProperty(value = "订单号")
    private String sn;

    @NotNull
    @ApiModelProperty(value = "客户端类型")
    private String clientType;
}
