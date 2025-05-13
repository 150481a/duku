package org.duku.mall.framework.starter.common.modules.good.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.DraftGoods;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Wholesale;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsParamsDTO;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DraftGoodsVO extends DraftGoods {

    private static final long serialVersionUID = 6377623919990713567L;

    @ApiModelProperty(value = "分类名称")
    private List<String> categoryName;

    @ApiModelProperty(value = "商品参数")
    private List<GoodsParamsDTO> goodsParamsDTOList;

    @ApiModelProperty(value = "商品图片")
    private List<String> goodsGalleryList;

    @ApiModelProperty(value = "sku列表")
    private List<GoodsSkuVO> skuList;

    /**
     * 批发商品规则
     */
    @ApiModelProperty(value = "批发商品规则")
    private List<Wholesale> wholesaleList;
}
