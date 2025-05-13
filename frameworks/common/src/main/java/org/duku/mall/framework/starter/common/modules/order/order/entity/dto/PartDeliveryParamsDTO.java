package org.duku.mall.framework.starter.common.modules.order.order.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PartDeliveryParamsDTO {
    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "发货单号")
    private String logisticsNo;

    @ApiModelProperty(value = "发货方式")
    private String logisticsId;

    @ApiModelProperty(value = "物流详细")
    private List<PartDeliveryDTO> partDeliveryDTOList;
}
