package org.duku.mall.framework.starter.common.modules.good.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsSku;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GoodsSkuDTO extends GoodsSku {
    private static final long serialVersionUID = 6600436187015048097L;

    @ApiModelProperty(value = "商品参数json")
    private String params;
}
