package org.duku.mall.framework.starter.bases.config;

import org.duku.mall.framework.starter.bases.ApplicationContextHolder;
import org.duku.mall.framework.starter.bases.init.ApplicationContentPostProcessor;
import org.duku.mall.framework.starter.bases.safa.FastJsonSafeMode;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationBaseAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public ApplicationContextHolder applicationContextHolder() {
        return new ApplicationContextHolder();
    }


    @Bean
    @ConditionalOnMissingBean
    public ApplicationContentPostProcessor congoApplicationContentPostProcessor(ApplicationContext applicationContext) {
        return new ApplicationContentPostProcessor(applicationContext);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "framework.fastjson.safa-mode", havingValue = "true")
    public FastJsonSafeMode congoFastJsonSafeMode() {
        return new FastJsonSafeMode();
    }
}


