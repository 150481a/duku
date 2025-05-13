package org.duku.mall.framework.starter.common.modules.promotion.entity.vos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Coupon;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.PromotionGoods;
import org.springframework.beans.BeanUtils;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "优惠券")
@ToString(callSuper = true)
@NoArgsConstructor
public class CouponVO extends Coupon {
    private static final long serialVersionUID = 8372420376262437018L;

    /**
     * 促销关联的商品
     */
    @ApiModelProperty(value = "优惠券关联商品集合")
    private List<PromotionGoods> promotionGoodsList;

    public CouponVO(Coupon coupon) {
        if (coupon == null) {
            return;
        }
        BeanUtils.copyProperties(coupon, this);
    }
}
