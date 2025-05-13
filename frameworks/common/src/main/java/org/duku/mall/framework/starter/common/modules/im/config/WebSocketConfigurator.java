package org.duku.mall.framework.starter.common.modules.im.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnWebApplication
@Configuration
public class WebSocketConfigurator {
    @Bean
    public CustomSpringConfigurator customSpringConfigurator() {
        // This is just to get context
        return new CustomSpringConfigurator();
    }
}
