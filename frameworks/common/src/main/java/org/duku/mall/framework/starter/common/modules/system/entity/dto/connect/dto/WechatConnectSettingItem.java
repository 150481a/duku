package org.duku.mall.framework.starter.common.modules.system.entity.dto.connect.dto;

import lombok.Data;

@Data
public class WechatConnectSettingItem {

    /**
     * @See ClientType
     */
    private String clientType;

    private String appId;

    private String appSecret;
}
