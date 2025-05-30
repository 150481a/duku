package org.duku.mall.framework.starter.common.modules.good.entity.params;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsAuthEnum;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsSalesModeEnum;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsStatusEnum;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsTypeEnum;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsSearchParams  extends PageVO {

    private static final long serialVersionUID = 2544015852728566887L;


    @ApiModelProperty(value = "商品编号")
    private String goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品编号")
    private String id;

    @ApiModelProperty(value = "商品编号")
    private List<String> ids;

    @ApiModelProperty(value = "商家ID")
    private String storeId;

    @ApiModelProperty(value = "卖家名字")
    private String storeName;

    @ApiModelProperty(value = "价格,可以为范围，如10_1000")
    private String price;

    @ApiModelProperty(value = "分类path")
    private String categoryPath;

    @ApiModelProperty(value = "店铺分类id")
    private String storeCategoryPath;

    @ApiModelProperty(value = "是否自营")
    private Boolean selfOperated;

    /**
     * @see GoodsStatusEnum
     */
    @ApiModelProperty(value = "上下架状态")
    private String marketEnable;

    /**
     * @see GoodsAuthEnum
     */
    @ApiModelProperty(value = "审核状态")
    private String authFlag;

    @ApiModelProperty(value = "库存数量")
    private Integer leQuantity;

    @ApiModelProperty(value = "库存数量")
    private Integer geQuantity;

    @ApiModelProperty(value = "是否为推荐商品")
    private Boolean recommend;

    /**
     * @see GoodsTypeEnum
     */
    @ApiModelProperty(value = "商品类型")
    private String goodsType;

    /**
     * @see GoodsSalesModeEnum
     */
    @ApiModelProperty(value = "销售模式", required = true)
    private String salesModel;

    @ApiModelProperty(value = "预警库存")
    private Boolean alertQuantity;

    public <T> QueryWrapper<T> queryWrapper() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (CharSequenceUtil.isNotEmpty(goodsId)) {
            queryWrapper.eq("goods_id", goodsId);
        }
        if (CharSequenceUtil.isNotEmpty(goodsName)) {
            queryWrapper.like("goods_name", goodsName);
        }
        if (CharSequenceUtil.isNotEmpty(id)) {
            queryWrapper.in("id", Arrays.asList(id.split(",")));
        }
        if (CollUtil.isNotEmpty(ids)) {
            queryWrapper.in("id", ids);
        }
        if (CharSequenceUtil.isNotEmpty(storeId)) {
            queryWrapper.eq("store_id", storeId);
        }
        if (CharSequenceUtil.isNotEmpty(storeName)) {
            queryWrapper.like("store_name", storeName);
        }
        if (CharSequenceUtil.isNotEmpty(categoryPath)) {
            queryWrapper.like("category_path", categoryPath);
        }
        if (CharSequenceUtil.isNotEmpty(storeCategoryPath)) {
            queryWrapper.like("store_category_path", storeCategoryPath);
        }
        if (selfOperated != null) {
            queryWrapper.eq("self_operated", selfOperated);
        }
        if (CharSequenceUtil.isNotEmpty(marketEnable)) {
            queryWrapper.eq("market_enable", marketEnable);
        }
        if (CharSequenceUtil.isNotEmpty(authFlag)) {
            queryWrapper.eq("auth_flag", authFlag);
        }
        if (leQuantity != null) {
            queryWrapper.le("quantity", leQuantity);
        }
        if (geQuantity != null) {
            queryWrapper.gt("quantity", geQuantity);
        }
        if (recommend != null) {
            queryWrapper.le("recommend", recommend);
        }
        if (CharSequenceUtil.isNotEmpty(goodsType)) {
            queryWrapper.eq("goods_type", goodsType);
        }
        if (CharSequenceUtil.isNotEmpty(salesModel)) {
            queryWrapper.eq("sales_model", salesModel);
        }
        if(alertQuantity != null && alertQuantity){
            queryWrapper.apply("quantity <= alert_quantity");
            queryWrapper.ge("alert_quantity", 0);
        }
        queryWrapper.in(CollUtil.isNotEmpty(ids), "id", ids);

        queryWrapper.eq("delete_flag", false);
        this.betweenWrapper(queryWrapper);
        return queryWrapper;
    }

    private <T> void betweenWrapper(QueryWrapper<T> queryWrapper) {
        if (CharSequenceUtil.isNotEmpty(price)) {
            String[] s = price.split("_");
            if (s.length > 1) {
                queryWrapper.between("price", s[0], s[1]);
            } else {
                queryWrapper.ge("price", s[0]);
            }
        }
    }
}
