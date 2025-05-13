package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class H5Info {
    /**
     * 场景类型
     */
    private String type;
    /**
     * 应用名称
     */
    private String app_name;
    /**
     * 网站URL
     */
    private String app_url;
    /**
     * iOS 平台 BundleID
     */
    private String bundle_id;
    /**
     * Android 平台 PackageName
     */
    private String package_name;
}
