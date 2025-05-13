package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.convention.enums.PromotionTypeEnum;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsSku;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.PromotionGoods;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dto.search.PromotionGoodsSearchParams;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.PromotionGoodsMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.PromotionGoodsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PromotionGoodsServiceImpl extends ServiceImpl <PromotionGoodsMapper, PromotionGoods> implements PromotionGoodsService {
    @Override
    public List<PromotionGoods> findSkuValidPromotion(String skuId, String storeIds) {
        return List.of();
    }

    @Override
    public List<PromotionGoods> findSkuValidPromotions(List<String> skus) {
        return List.of();
    }

    @Override
    public Page<PromotionGoods> pageFindAll(PromotionGoodsSearchParams searchParams, PageVO pageVo) {
        return null;
    }

    @Override
    public List<PromotionGoods> listFindAll(PromotionGoodsSearchParams searchParams) {
        return List.of();
    }

    @Override
    public PromotionGoods getPromotionsGoods(PromotionGoodsSearchParams searchParams) {
        return null;
    }

    @Override
    public PromotionGoods getValidPromotionsGoods(String skuId, List<String> promotionTypes) {
        return null;
    }

    @Override
    public Double getValidPromotionsGoodsPrice(String skuId, List<String> promotionTypes) {
        return 0.0;
    }

    @Override
    public Integer findInnerOverlapPromotionGoods(String promotionType, String skuId, Date startTime, Date endTime, String promotionId) {
        return 0;
    }

    @Override
    public Integer getPromotionGoodsStock(PromotionTypeEnum typeEnum, String promotionId, String skuId) {
        return 0;
    }

    @Override
    public List<Integer> getPromotionGoodsStock(PromotionTypeEnum typeEnum, String promotionId, List<String> skuId) {
        return List.of();
    }

    @Override
    public void updatePromotionGoodsStock(List<PromotionGoods> promotionGoodsList) {

    }

    @Override
    public void updatePromotionGoodsStock(String skuId, Integer quantity) {

    }

    @Override
    public void updatePromotionGoodsByPromotions(PromotionGoods promotionGoods) {

    }

    @Override
    public void deletePromotionGoods(String promotionId, List<String> skuIds) {

    }

    @Override
    public void deletePromotionGoods(List<String> promotionIds) {

    }

    @Override
    public void deletePromotionGoodsByGoods(List<String> goodsIds) {

    }

    @Override
    public void deletePromotionGoods(PromotionGoodsSearchParams searchParams) {

    }

    @Override
    public Map<String, Object> getCurrentGoodsPromotion(GoodsSku dataSku, String cartType) {
        return Map.of();
    }
}
