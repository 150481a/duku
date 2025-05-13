package org.duku.mall.framework.starter.common.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "lili.domain")
public class DomainProperties {
    /**
     * 买家PC端域名
     */
    private String pc;

    /**
     * 买家WAP端域名
     */
    private String wap;

    /**
     * Store域名
     */
    private String store;

    /**
     * 管理端域名
     */
    private String admin;
}
