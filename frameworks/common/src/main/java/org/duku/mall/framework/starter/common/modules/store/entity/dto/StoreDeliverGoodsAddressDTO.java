package org.duku.mall.framework.starter.common.modules.store.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StoreDeliverGoodsAddressDTO {

    @ApiModelProperty(value = "发货人姓名")
    private String salesConsignorName;

    @ApiModelProperty(value = "发货人手机号")
    private String salesConsignorMobile;

    @ApiModelProperty(value = "地址Id， '，'分割")
    private String salesConsignorAddressId;

    @ApiModelProperty(value = "地址名称， '，'分割")
    private String salesConsignorAddressPath;

    @ApiModelProperty(value = "详细地址")
    private String salesConsignorDetail;
}
