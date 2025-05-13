package org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PaymentSupportItem {


    @ApiModelProperty(value = "客户端 h5/app/小程序/pc")
    private String client;

    @ApiModelProperty(value = "支持的支付方式")
    private List<String> supports;
}
