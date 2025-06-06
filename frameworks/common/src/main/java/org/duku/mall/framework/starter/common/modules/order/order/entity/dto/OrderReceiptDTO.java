package org.duku.mall.framework.starter.common.modules.order.order.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Receipt;

@Data
@ApiModel(value = "订单发票")
public class OrderReceiptDTO extends Receipt {
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;
}
