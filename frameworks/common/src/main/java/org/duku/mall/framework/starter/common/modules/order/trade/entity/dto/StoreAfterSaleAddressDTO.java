package org.duku.mall.framework.starter.common.modules.order.trade.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StoreAfterSaleAddressDTO {

    @ApiModelProperty(value = "收货人姓名")
    private String salesConsigneeName;

    @ApiModelProperty(value = "收件人手机")
    private String salesConsigneeMobile;

    @ApiModelProperty(value = "地址Id， '，'分割")
    private String salesConsigneeAddressId;

    @ApiModelProperty(value = "地址名称， '，'分割")
    private String salesConsigneeAddressPath;

    @ApiModelProperty(value = "详细地址")
    private String salesConsigneeDetail;
}
