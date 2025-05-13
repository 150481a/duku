package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Detail {
    /**
     * 订单原价
     */
    private int cost_price;
    /**
     * 商品小票ID
     */
    private String invoice_id;
    /**
     * 单品列表
     */
    private List<GoodsDetail> goods_detail;
}
