package org.duku.mall.framework.starter.bases.init;

import org.springframework.context.ApplicationEvent;

/**
 *  应用初始化事件
 *
 *   <p> 规约事件，通过此事件可以查看业务系统所有初始化行为
 */
public class ApplicationInitializingEvent extends ApplicationEvent {

    /**
     *  构造函数
     *
     *  @param source 事件源对象
     */
    public ApplicationInitializingEvent(Object source) {
        super(source);
    }
}
