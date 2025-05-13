package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model;


import com.alipay.api.domain.StoreInfo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SceneInfo {
    /**
     * 用户终端IP
     */
    private String payer_client_ip;
    /**
     * 商户端设备号
     */
    private String device_id;
    /**
     * 商户门店信息
     */
    private StoreInfo store_info;
    /**
     * H5 场景信息
     */
    private H5Info h5_info;
}
