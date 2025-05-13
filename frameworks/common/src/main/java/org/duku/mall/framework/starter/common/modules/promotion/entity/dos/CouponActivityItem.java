package org.duku.mall.framework.starter.common.modules.promotion.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_coupon_activity_item")
@ApiModel(value = "优惠券活动-优惠券关联实体类")
public class CouponActivityItem extends BaseEntity {
    @ApiModelProperty(value = "优惠券活动ID")
    private String activityId;

    @ApiModelProperty(value = "优惠券ID")
    private String couponId;

    @ApiModelProperty(value = "优惠券数量")
    private Integer num;
}
