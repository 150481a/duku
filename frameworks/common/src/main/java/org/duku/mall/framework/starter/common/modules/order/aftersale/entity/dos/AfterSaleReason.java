package org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_after_sale_reason")
@ApiModel(value = "售后原因")
public class AfterSaleReason extends BaseEntity {
    @NotNull
    @ApiModelProperty(value = "售后原因")
    private String reason;

    /**
     * @see cn.lili.modules.order.trade.entity.enums.AfterSaleTypeEnum
     */
    @ApiModelProperty(value = "原因类型", allowableValues = "CANCEL,RETURN_GOODS,RETURN_MONEY,COMPLAIN")
    @NotNull
    private String serviceType;
}
