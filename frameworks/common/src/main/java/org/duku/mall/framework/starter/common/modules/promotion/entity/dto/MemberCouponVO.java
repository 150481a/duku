package org.duku.mall.framework.starter.common.modules.promotion.entity.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.MemberCoupon;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MemberCouponVO extends MemberCoupon{
    private static final long serialVersionUID = -5533168813075444962L;

    @ApiModelProperty(value = "优惠券名称")
    private String couponName;

    @ApiModelProperty(value = "无法使用原因")
    private String reason;

    public MemberCouponVO(MemberCoupon memberCoupon, String reason) {
        BeanUtil.copyProperties(memberCoupon, this);
        this.reason = reason;
    }
}
