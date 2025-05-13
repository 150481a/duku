package org.duku.mall.framework.starter.common.modules.order.cart.render.service.impl;

import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.TradeDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.enums.RenderStepEnums;
import org.duku.mall.framework.starter.common.modules.order.cart.render.service.CartRenderStep;
import org.duku.mall.framework.starter.common.modules.promotion.service.KanjiaActivityGoodsService;
import org.duku.mall.framework.starter.common.modules.promotion.service.KanjiaActivityService;
import org.duku.mall.framework.starter.common.modules.promotion.service.PointsGoodsService;
import org.duku.mall.framework.starter.common.modules.promotion.service.PromotionGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuPromotionRender implements CartRenderStep {


    @Autowired
    private KanjiaActivityService kanjiaActivityService;

    @Autowired
    private KanjiaActivityGoodsService kanjiaActivityGoodsService;

    @Autowired
    private PointsGoodsService pointsGoodsService;

    /**
     * 促销商品
     */
    @Autowired
    private PromotionGoodsService promotionGoodsService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private SingletonCache cache;

    @Override
    public RenderStepEnums step() {
        return null;
    }

    @Override
    public void render(TradeDTO tradeDTO) {

    }
}
