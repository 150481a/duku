package org.duku.mall.framework.starter.common.modules.order.cart.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class StoreRemarkDTO implements Serializable {
    private static final long serialVersionUID = -6793274046513576434L;
    @ApiModelProperty(value = "店铺id")
    private String storeId;

    @ApiModelProperty(value = "备注")
    private String remark;
}
