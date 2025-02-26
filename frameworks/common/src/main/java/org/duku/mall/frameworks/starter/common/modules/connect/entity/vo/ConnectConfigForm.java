package org.duku.mall.frameworks.starter.common.modules.connect.entity.vo;

import lombok.Data;

@Data
public class ConnectConfigForm {
    /**
     * 配置名称
     */
    private String name;
    /**
     * 配置key
     */
    private String key;
    /**
     * 配置表单
     */
    private String form;
}
