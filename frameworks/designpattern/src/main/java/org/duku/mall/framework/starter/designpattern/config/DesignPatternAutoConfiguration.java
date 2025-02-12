package org.duku.mall.framework.starter.designpattern.config;

import org.duku.mall.framework.starter.designpattern.chain.AbstractChainContext;
import org.duku.mall.framework.starter.designpattern.strategy.AbstractStrategyChoose;
import org.duku.mall.frameworks.starter.bases.config.ApplicationBaseAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 *设计模式自动装配
 */
@ImportAutoConfiguration(ApplicationBaseAutoConfiguration.class)
public class DesignPatternAutoConfiguration {
    /**
     * 策略模式选择器
     */
    @Bean
    public AbstractStrategyChoose abstractStrategyChoose() {
        return new AbstractStrategyChoose();
    }

    /**
     * 责任链上下文
     */
    @Bean
    public AbstractChainContext abstractChainContext() {
        return new AbstractChainContext();
    }
}
