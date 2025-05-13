package org.duku.mall.framework.starter.common.common.aop.annotation;

import java.lang.annotation.*;

/**
 * 防重复提交注解
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface  PreventDuplicateSubmissions {


    /**
     * 过期时间 默认3秒，即3秒内无法重复点击。
     */
    long expire() default 3;
    /**
     * 用户间隔离，默认false。
     * 如果为true则全局限制，为true需要用户登录状态，否则则是全局隔离
     */
    boolean userIsolation() default false;
}
