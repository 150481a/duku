package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.unionpay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class AuthCodeToOpenIdModel extends BaseModel {
    private String service;
    private String version;
    private String charset;
    private String sign_type;
    private String mch_id;
    private String sub_appid;
    private String auth_code;
    private String nonce_str;
    private String sign;
    private String sign_agentno;
    private String groupno;
}
