package org.duku.mall.framework.starter.common.modules.good.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Commodity;

@Data
public class CommodityVO extends Commodity {
    @ApiModelProperty(value = "SKU库存")
    private Integer quantity;

    @ApiModelProperty(value = "店铺名称")
    private String storeName;
}
