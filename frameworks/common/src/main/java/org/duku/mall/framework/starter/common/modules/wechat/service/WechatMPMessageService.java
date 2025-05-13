package org.duku.mall.framework.starter.common.modules.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.wechat.entity.dos.WechatMPMessage;

public interface WechatMPMessageService extends IService<WechatMPMessage> {

    /**
     * 初始化微信消息订阅模版
     */
    void init();
}
