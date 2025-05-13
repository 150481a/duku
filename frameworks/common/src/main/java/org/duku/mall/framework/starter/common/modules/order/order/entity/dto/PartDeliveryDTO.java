package org.duku.mall.framework.starter.common.modules.order.order.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PartDeliveryDTO {

    @ApiModelProperty(value = "订单货物Id")
    private String orderItemId;

    @ApiModelProperty(value = "发货数量")
    private Integer deliveryNum;
}
