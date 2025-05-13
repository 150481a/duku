package org.duku.mall.framework.starter.common.modules.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.wechat.entity.dos.WechatMessage;

public interface WechatMessageService extends IService<WechatMessage> {
    /**
     * 初始化微信消息模版
     */
    void init();
}
