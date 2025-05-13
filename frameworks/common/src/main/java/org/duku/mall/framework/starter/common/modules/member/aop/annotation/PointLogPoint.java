package org.duku.mall.framework.starter.common.modules.member.aop.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PointLogPoint {
}
