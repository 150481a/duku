package org.duku.mall.framework.starter.common.modules.order.order.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.convention.enums.PromotionTypeEnum;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountPriceItem {
    @ApiModelProperty(value = "促销类型")
    private PromotionTypeEnum promotionTypeEnum;

    @ApiModelProperty(value = "促销id")
    private String promotionId;

    @ApiModelProperty(value = "减免金额")
    private Double discountPrice;

    @ApiModelProperty(value = "涉及 商品ID")
    private String goodsId;

    @ApiModelProperty(value = "涉及 SKU ID")
    private String skuId;


    public String getPromotionName() {
        return promotionTypeEnum.description();
    }
}
