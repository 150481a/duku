package org.duku.mall.framework.starter.common.modules.order.cart.entity.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.StoreRemarkDTO;

import java.io.Serializable;
import java.util.List;

@Data
public class TradeParams implements Serializable {
    private static final long serialVersionUID = -8383072817737513063L;

    @ApiModelProperty(value = "购物车购买：CART/立即购买：BUY_NOW/拼团购买：PINTUAN / 积分购买：POINT")
    private String way;

    /**
     * @see ClientTypeEnum
     */
    @ApiModelProperty(value = "客户端：H5/移动端 PC/PC端,WECHAT_MP/小程序端,APP/移动应用端")
    private String client;

    @ApiModelProperty(value = "店铺备注")
    private List<StoreRemarkDTO> remark;

    @ApiModelProperty(value = "是否为其他订单下的订单，如果是则为依赖订单的sn，否则为空")
    private String parentOrderSn;
}
