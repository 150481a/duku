package org.duku.mall.framework.starter.common.modules.order.cart.render.service;

import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.TradeDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.enums.RenderStepEnums;

public interface CartRenderStep {

    /**
     * 渲染价格步骤
     *
     * @return 渲染枚举
     */
    RenderStepEnums step();

    /**
     * 渲染一笔交易
     *
     * @param tradeDTO 交易DTO
     */
    void render(TradeDTO tradeDTO);
}
