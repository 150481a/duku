package org.duku.mall.framework.starter.common.common.aop.annotation;

import java.lang.annotation.*;

/**
 * 用户登录注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DemoSite {
}
