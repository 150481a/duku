package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model;

import com.alipay.api.domain.SettleInfo;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UnifiedOrderModel  {
    /**
     * 公众号ID
     */
    private String appid;
    /**
     * 服务商公众号ID
     */
    private String sp_appid;
    /**
     * 直连商户号
     */
    private String mchid;
    /**
     * 服务商户号
     */
    private String sp_mchid;
    /**
     * 子商户公众号ID
     */
    private String sub_appid;
    /**
     * 子商户号
     */
    private String sub_mchid;
    /**
     * 商品描述
     */
    private String description;

    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 交易结束时间
     */
    private String time_expire;
    /**
     * 附加数据
     */
    private String attach;
    /**
     * 通知地址
     */
    private String notify_url;
    /**
     * 订单优惠标记
     */
    private String goods_tag;
    /**
     * 结算信息
     */
    private SettleInfo settle_info;
    /**
     * 订单金额
     */
    private Amount amount;
    /**
     * 支付者
     */
    private Payer payer;
    /**
     * 优惠功能
     */
    private Detail detail;
    /**
     * 场景信息
     */
    private SceneInfo scene_info;
}
