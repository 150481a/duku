package org.duku.mall.framework.starter.common.common.aop.annotation;

import java.lang.annotation.*;

/**
 * 异常重试注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RetryOperation {

    /**
     * 重试次数
     */
    int retryCount() default 3;

    /**
     * 重试间隔
     */
    int waitSeconds() default 10;

}
