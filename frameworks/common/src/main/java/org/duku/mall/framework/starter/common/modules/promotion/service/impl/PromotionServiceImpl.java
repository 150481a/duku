package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.PromotionGoods;
import org.duku.mall.framework.starter.common.modules.promotion.service.PromotionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Override
    public Map<String, List<PromotionGoods>> getCurrentPromotion() {
        return Map.of();
    }

    @Override
    public Map<String, Object> getGoodsSkuPromotionMap(String storeId, String goodsSkuId) {
        return Map.of();
    }

    @Override
    public void removeByGoodsIds(String goodsIdsJsonStr) {

    }

    @Override
    public Map<String, Object> wrapperPromotionMapList(List<PromotionGoods> promotionGoodsList) {
        return Map.of();
    }
}
