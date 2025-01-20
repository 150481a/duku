package org.duku.mall.frameworks.starter.bases.init;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 应用初始化后置处理器，防止Spring事件被多次执行
 */
@RequiredArgsConstructor
public class ApplicationContentPostProcessor implements ApplicationListener<ApplicationReadyEvent> {

    private final ApplicationContext applicationContext;


    /**
     * 执行标记，有且执行一次，确保Spring事件只被执行一次 {@link ApplicationReadyEvent}
     */
    private final AtomicBoolean executeOnlyOnce = new AtomicBoolean(false);


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        if (!executeOnlyOnce.compareAndSet(false, true)) return;
        // 这里可以执行一些初始化后置操作，比如初始化数据
        applicationContext.publishEvent(new ApplicationInitializingEvent(this));

    }
}
