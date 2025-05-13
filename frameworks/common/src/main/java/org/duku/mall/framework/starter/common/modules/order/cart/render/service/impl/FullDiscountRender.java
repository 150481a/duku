package org.duku.mall.framework.starter.common.modules.order.cart.render.service.impl;

import org.duku.mall.framework.starter.common.modules.good.service.GoodsSkuService;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.TradeDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.enums.RenderStepEnums;
import org.duku.mall.framework.starter.common.modules.order.cart.render.service.CartRenderStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullDiscountRender implements CartRenderStep {

    @Autowired
    private GoodsSkuService goodsSkuService;


    @Override
    public RenderStepEnums step() {
        return null;
    }

    @Override
    public void render(TradeDTO tradeDTO) {

    }
}
