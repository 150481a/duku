package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.enums;

public enum WechatDomain {

    /**
     * 中国国内
     */
    CHINA("https://api.mch.weixin.qq.com"),
    /**
     * 中国国内(备用域名)
     */
    CHINA2("https://api2.mch.weixin.qq.com"),
    /**
     * 东南亚
     */
    HK("https://apihk.mch.weixin.qq.com"),
    /**
     * 其它
     */
    US("https://apius.mch.weixin.qq.com"),
    /**
     * 获取公钥
     */
    FRAUD("https://fraud.mch.weixin.qq.com"),
    /**
     * 活动
     */
    ACTION("https://action.weixin.qq.com"),
    /**
     * 刷脸支付
     * PAY_APP
     */
    PAY_APP("https://payapp.weixin.qq.com");


    /**
     * 域名
     */
    private final String domain;

    WechatDomain(String domain) {
        this.domain = domain;
    }

    public String getType() {
        return domain;
    }

    @Override
    public String toString() {
        return domain;
    }
}
