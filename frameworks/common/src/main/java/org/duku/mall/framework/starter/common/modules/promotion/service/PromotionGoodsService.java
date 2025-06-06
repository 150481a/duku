package org.duku.mall.framework.starter.common.modules.promotion.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.convention.enums.PromotionTypeEnum;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsSku;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.PromotionGoods;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dto.search.PromotionGoodsSearchParams;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PromotionGoodsService extends IService<PromotionGoods> {

    /**
     * 缓存商品库存key
     *
     * @param typeEnum    促销分类枚举
     * @param promotionId 促销活动Id
     * @param skuId       skuId
     * @return 缓存商品库存key
     */
    static String getPromotionGoodsStockCacheKey(PromotionTypeEnum typeEnum, String promotionId, String skuId) {
        //ps: 2023-06-09 促销商品库存与普通商品库存不在同一槽内，会导致库存扣减lua脚本无法执行
        return CachePrefix.SKU_STOCK.getPrefix() + "_" + typeEnum.name() + "_" + promotionId + "_" + skuId;
    }

    /**
     * 获取某sku所有有效活动
     *
     * @param skuId    商品skuId
     * @param storeIds 店铺id
     * @return 促销商品集合
     */
    List<PromotionGoods> findSkuValidPromotion(String skuId, String storeIds);


    /**
     * 获取sku所有有效活动
     *
     * @param skus 商品skuId
     * @return 促销商品集合
     */
    List<PromotionGoods> findSkuValidPromotions(List<String> skus);

    /**
     * 分页获取促销商品信息
     *
     * @param searchParams 查询参数
     * @param pageVo       分页参数
     * @return 促销商品列表
     */
    Page<PromotionGoods> pageFindAll(PromotionGoodsSearchParams searchParams, PageVO pageVo);

    /**
     * 获取促销商品信息
     *
     * @param searchParams 查询参数
     * @return 促销商品列表
     */
    List<PromotionGoods> listFindAll(PromotionGoodsSearchParams searchParams);

    /**
     * 获取促销商品信息
     *
     * @param searchParams 查询参数
     * @return 促销商品信息
     */
    PromotionGoods getPromotionsGoods(PromotionGoodsSearchParams searchParams);


    /**
     * 获取当前有效时间特定促销类型的促销商品信息
     *
     * @param skuId          skuId
     * @param promotionTypes 特定促销类型
     * @return 促销商品信息
     */
    PromotionGoods getValidPromotionsGoods(String skuId, List<String> promotionTypes);

    /**
     * 获取当前有效时间特定促销类型的促销商品价格
     *
     * @param skuId          skuId
     * @param promotionTypes 特定促销类型
     * @return 促销商品价格
     */
    Double getValidPromotionsGoodsPrice(String skuId, List<String> promotionTypes);

    /**
     * 查询参加活动促销商品是否同时参加指定类型的活动
     *
     * @param promotionType 促销类型
     * @param skuId         skuId
     * @param startTime     开始时间
     * @param endTime       结束时间
     * @param promotionId   促销活动id(是否排除当前活动，如排除，则填写，没有的话，为null)
     * @return 共参加了几种活动
     */
    Integer findInnerOverlapPromotionGoods(String promotionType, String skuId, Date startTime, Date endTime, String promotionId);


    /**
     * 获取促销活动商品库存
     *
     * @param typeEnum    促销商品类型
     * @param promotionId 促销活动id
     * @param skuId       商品skuId
     * @return 促销活动商品库存
     */
    Integer getPromotionGoodsStock(PromotionTypeEnum typeEnum, String promotionId, String skuId);

    /**
     * 批量获取促销活动商品库存
     *
     * @param typeEnum    促销商品类型
     * @param promotionId 促销活动id
     * @param skuId       批量商品skuId
     * @return 促销活动商品库存
     */
    List<Integer> getPromotionGoodsStock(PromotionTypeEnum typeEnum, String promotionId, List<String> skuId);

    /**
     * 更新促销活动商品库存
     *
     * @param promotionGoodsList 更新促销活动商品信息
     */
    void updatePromotionGoodsStock(List<PromotionGoods> promotionGoodsList);

    /**
     * 更新促销活动商品库存
     *
     * @param skuId    商品skuId
     * @param quantity 库存
     */
    void updatePromotionGoodsStock(String skuId, Integer quantity);

    /**
     * 更新促销活动商品索引
     *
     * @param promotionGoods 促销商品信息
     */
    void updatePromotionGoodsByPromotions(PromotionGoods promotionGoods);

    /**
     * 删除促销商品
     *
     * @param promotionId 促销活动id
     * @param skuIds      skuId
     */
    void deletePromotionGoods(String promotionId, List<String> skuIds);

    /**
     * 删除促销促销商品
     *
     * @param promotionIds 促销活动id
     */
    void deletePromotionGoods(List<String> promotionIds);

    /**
     * 删除商品的促销
     *
     * @param goodsIds 商品id
     */
    void deletePromotionGoodsByGoods(List<String> goodsIds);

    /**
     * 根据参数删除促销商品
     *
     * @param searchParams 查询参数
     */
    void deletePromotionGoods(PromotionGoodsSearchParams searchParams);

    /**
     * 获取当前商品促销信息
     *
     * @param dataSku  商品sku信息
     * @param cartType 购物车类型
     * @return 当前商品促销信息
     */
    Map<String, Object> getCurrentGoodsPromotion(GoodsSku dataSku, String cartType);
}
