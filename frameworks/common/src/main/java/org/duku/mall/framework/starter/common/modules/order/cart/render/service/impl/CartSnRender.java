package org.duku.mall.framework.starter.common.modules.order.cart.render.service.impl;

import org.duku.mall.framework.starter.distributedid.toolkit.SnowflakeIdUtil;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.StoreRemarkDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.TradeDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.enums.RenderStepEnums;
import org.duku.mall.framework.starter.common.modules.order.cart.render.service.CartRenderStep;
import org.springframework.stereotype.Service;

@Service
public class CartSnRender implements CartRenderStep {
    @Override
    public RenderStepEnums step() {
        return RenderStepEnums.CART_SN;
    }

    @Override
    public void render(TradeDTO tradeDTO) {

        //生成各个sn
        tradeDTO.setSn(SnowflakeIdUtil.createStr("T"));
        tradeDTO.getCartList().forEach(item -> {
            //写入备注
            if (tradeDTO.getStoreRemark() != null) {
                for (StoreRemarkDTO remark : tradeDTO.getStoreRemark()) {
                    if (item.getStoreId().equals(remark.getStoreId())) {
                        item.setRemark(remark.getRemark());
                    }
                }
            }
            item.setSn(SnowflakeIdUtil.createStr("O"));
        });

    }
}
