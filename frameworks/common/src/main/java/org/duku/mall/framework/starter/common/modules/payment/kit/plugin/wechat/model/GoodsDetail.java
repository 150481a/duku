package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GoodsDetail {

    /**
     * 商户侧商品编码
     */
    private String merchant_goods_id;
    /**
     * 微信侧商品编码
     */
    private String wechatpay_goods_id;
    /**
     * 商品名称
     */
    private String goods_name;
    /**
     * 商品数量
     */
    private int quantity;
    /**
     * 商品单价
     */
    private int unit_price;
}
