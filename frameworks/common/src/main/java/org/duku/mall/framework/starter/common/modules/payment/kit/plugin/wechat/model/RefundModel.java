
package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model;


import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>IJPay 让支付触手可及，封装了微信支付、支付宝支付、银联支付常用的支付方式以及各种常用的接口。</p>
 *
 * <p>不依赖任何第三方 mvc 框架，仅仅作为工具使用简单快速完成支付模块的开发，可轻松嵌入到任何系统里。 </p>
 *
 * <p>IJPay 交流群: 723992875</p>
 *
 * <p>Node.js 版: https://gitee.com/javen205/TNWX</p>
 *
 * <p>云闪付-退款</p>
 *
 * @author Javen
 */
@Data
@Accessors(chain = true)
public class RefundModel  {


    /**
     * 原支付交易对应的微信订单号
     */
    private String transaction_id;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 商户退款单号
     */
    private String out_refund_no;

    /**
     * 退款理由
     */
    private String reason;

    /**
     * 退款金额
     */
    private Amount amount;

    /**
     * 通知地址
     */
    private String notify_url;
}
