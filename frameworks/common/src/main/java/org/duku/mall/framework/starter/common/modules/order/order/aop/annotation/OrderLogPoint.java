package org.duku.mall.framework.starter.common.modules.order.order.aop.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OrderLogPoint {

    /**
     * 日志名称
     *
     * @return
     */
    String description();

    /**
     * 订单编号
     *
     * @return
     */
    String orderSn();
}
