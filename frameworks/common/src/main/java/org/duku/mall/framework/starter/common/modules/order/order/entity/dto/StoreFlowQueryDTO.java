package org.duku.mall.framework.starter.common.modules.order.order.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.vo.PageVO;

@Data
@Builder
public class StoreFlowQueryDTO {
    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "售后编号")
    private String refundSn;

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "订单货物编号")
    private String orderItemSn;

    @ApiModelProperty(value = "过滤只看分销订单")
    private Boolean justDistribution;

    @ApiModelProperty("结算单")
    private Bill bill;

    @ApiModelProperty(value = "分页")
    private PageVO pageVO;
}
