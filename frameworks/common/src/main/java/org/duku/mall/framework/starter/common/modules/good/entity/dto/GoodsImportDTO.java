package org.duku.mall.framework.starter.common.modules.good.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import  org.duku.mall.framework.starter.common.modules.good.entity.dos.Category;
import java.util.List;

@Data
public class GoodsImportDTO {
    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品卖点")
    private String sellingPoint;

    @ApiModelProperty(value = "商品分类")
    private Category category;

    @ApiModelProperty(value = "运费模板")
    private String template;

    @ApiModelProperty(value = "计量单位")
    private String goodsUnit;

    @ApiModelProperty(value = "发布状态")
    private Boolean release;

    @ApiModelProperty(value = "商品图片")
    private List<String> images;
    private List<String> goodsGalleryList;

    @ApiModelProperty(value = "成本价")
    private Double cost;

    @ApiModelProperty(value = "销售价")
    private Double price;

    @ApiModelProperty(value = "库存")
    private Integer quantity;

    @ApiModelProperty(value = "重量")
    private Double weight;

    @ApiModelProperty(value = "货号")
    private String sn;

    @ApiModelProperty(value = "详情")
    private String intro;

    @ApiModelProperty(value = "规格项")
    private String skuKey;

    @ApiModelProperty(value = "规格值")
    private String skuValue;
}
