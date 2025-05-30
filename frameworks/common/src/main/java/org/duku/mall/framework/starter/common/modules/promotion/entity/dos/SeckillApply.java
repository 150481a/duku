package org.duku.mall.framework.starter.common.modules.promotion.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.promotion.entity.enums.PromotionsApplyStatusEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_seckill_apply")
@ApiModel(value = "秒杀活动申请")
public class SeckillApply extends BaseEntity {

    private static final long serialVersionUID = 5440164641970820989L;

    @ApiModelProperty(value = "活动id", required = true)
    @NotNull(message = "活动id参数不能为空")
    @Min(value = 0, message = "活动id参数异常")
    private String seckillId;

    @ApiModelProperty(value = "时刻")
    @NotNull(message = "时刻参数不能为空")
    private Integer timeLine;

    @ApiModelProperty(value = "skuID")
    @NotNull(message = "skuId参数不能为空")
    @Min(value = 0, message = "skuID参数异常")
    private String skuId;

    @ApiModelProperty(value = "商品名称")
    @NotEmpty(message = "商品名称参数不能为空")
    private String goodsName;

    @ApiModelProperty(value = "商家id")
    private String storeId;

    @ApiModelProperty(value = "商家名称")
    private String storeName;

    @ApiModelProperty(value = "价格")
    @NotNull(message = "价格参数不能为空")
    @Min(value = 0, message = "价格参数不能小于0")
    private Double price;

    @ApiModelProperty(value = "促销数量")
    @NotNull(message = "促销数量参数不能为空")
    @Min(value = 0, message = "促销数量数不能小于0")
    private Integer quantity;

    /**
     * @see PromotionsApplyStatusEnum
     */
    @ApiModelProperty(value = "APPLY(\"申请\"), PASS(\"通过\"), REFUSE(\"拒绝\")")
    private String promotionApplyStatus;

    @ApiModelProperty(value = "驳回原因")
    private String failReason;

    @ApiModelProperty(value = "已售数量")
    private Integer salesNum;

    @ApiModelProperty(value = "商品原始价格")
    private Double originalPrice;

}
