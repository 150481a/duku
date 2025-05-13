package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsCollectionVO {


    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    @ApiModelProperty(value = "规格ID")
    private String skuId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(value = "商品价格")
    private Double price;

    @ApiModelProperty(value = "已失效")
    private String marketEnable;
}
