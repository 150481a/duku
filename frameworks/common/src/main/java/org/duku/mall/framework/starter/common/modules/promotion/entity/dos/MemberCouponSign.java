package org.duku.mall.framework.starter.common.modules.promotion.entity.dos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_member_coupon_sign")
@ApiModel(value = "会员优惠券领取标记")
public class MemberCouponSign extends BaseIdEntity {
    @ApiModelProperty(value = "优惠券活动ID")
    private String couponActivityId;

    @ApiModelProperty(value = "会员ID")
    private String memberId;

    @ApiModelProperty(value = "失效时间，到达失效时间后自动删除，用户可以再次领取")
    private Date invalidTime;


    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", hidden = true)
    @Field(type = FieldType.Date,  pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    private Date createTime;
}
