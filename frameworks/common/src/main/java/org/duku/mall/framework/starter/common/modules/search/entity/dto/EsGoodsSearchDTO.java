package org.duku.mall.framework.starter.common.modules.search.entity.dto;

import cn.hutool.core.text.CharSequenceUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.convention.enums.PromotionTypeEnum;
import org.duku.mall.framework.starter.common.common.utils.RegularUtil;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsTypeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class EsGoodsSearchDTO {

    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "分类")
    private String categoryId;

    @ApiModelProperty(value = "品牌,可以多选 品牌Id@品牌Id@品牌Id")
    private String brandId;

    @ApiModelProperty("是否为推荐商品")
    private Boolean recommend;

    @ApiModelProperty(value = "价格", example = "10_30")
    private String price;

    @ApiModelProperty(value = "属性:参数名_参数值@参数名_参数值", example = "屏幕类型_LED@屏幕尺寸_15英寸")
    private String prop;

    @ApiModelProperty(value = "规格项列表")
    private List<String> nameIds;

    @ApiModelProperty(value = "卖家id，搜索店铺商品的时候使用")
    private String storeId;

    @ApiModelProperty(value = "商家分组id，搜索店铺商品的时候使用")
    private String storeCatId;

    @ApiModelProperty(hidden = true)
    private Map<String, List<String>> notShowCol = new HashMap<>();

    @ApiModelProperty("当前商品skuId,根据当前浏览的商品信息来给用户推荐可能喜欢的商品")
    private String currentGoodsId;

    /**
     * @see PromotionTypeEnum
     */
    @ApiModelProperty("促销活动类型")
    private String promotionType;

    @ApiModelProperty(value = "促销活动id")
    private String promotionsId;

    /**
     * @see GoodsTypeEnum
     */
    @ApiModelProperty(value = "商品类型")
    private String goodsType;

    @ApiModelProperty("销售模式")
    private String salesModel;

    /**
     * @see GoodsTypeEnum
     */
    @ApiModelProperty(value = "除了当前商品类型之外")
    private String neGoodsType;

    @ApiModelProperty("除了销售模式当前销售模式之外")
    private String neSalesModel;

    //过滤搜索关键字
    public String getKeyword() {
        if (CharSequenceUtil.isNotEmpty(keyword)) {
            RegularUtil.replace(this.keyword);
        }
        return keyword;
    }
}
