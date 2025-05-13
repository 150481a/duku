package org.duku.mall.framework.starter.common.modules.wechat.service;

public interface WechatMPService {

    /**
     * 微信小程序-上传发货信息
     * @param orderSn
     */
    void uploadShippingInfo(String orderSn);
}
