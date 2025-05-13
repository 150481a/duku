package org.duku.mall.framework.starter.common.modules.system.entity.dto.connect;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.connect.dto.WechatConnectSettingItem;

import java.util.List;

@Data
public class WechatConnectSetting {
    /**
     * 微信联合登陆配置
     */
    List<WechatConnectSettingItem> wechatConnectSettingItems;
}
