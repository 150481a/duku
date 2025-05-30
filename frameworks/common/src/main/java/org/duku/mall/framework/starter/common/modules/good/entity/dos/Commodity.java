package org.duku.mall.framework.starter.common.modules.good.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@ApiModel(value = "Commodity", description = "直播商品")
@TableName("li_commodity")
public class Commodity extends BaseEntity {

    @ApiModelProperty(value = "图片")
    private String goodsImage;

    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
     * 1：一口价（只需要传入price，price2不传）
     * 2：价格区间（price字段为左边界，price2字段为右边界，price和price2必传）
     * 3：显示折扣价（price字段为原价，price2字段为现价， price和price2必传
     */
    @ApiModelProperty(value = "价格类型")
    private Integer priceType;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "价格2")
    private Double price2;

    @ApiModelProperty(value = "商品详情页的小程序路径")
    private String url;

    @ApiModelProperty(value = "微信程序直播商品ID")
    private Integer liveGoodsId;

    @ApiModelProperty(value = "审核单ID")
    private String auditId;

    @ApiModelProperty(value = "审核状态")
    private String auditStatus;

    @ApiModelProperty(value = "店铺ID")
    private String storeId;

    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    @ApiModelProperty(value = "规格ID")
    private String skuId;
}
