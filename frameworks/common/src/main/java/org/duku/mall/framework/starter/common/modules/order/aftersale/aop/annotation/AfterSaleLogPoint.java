package org.duku.mall.framework.starter.common.modules.order.aftersale.aop.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AfterSaleLogPoint {
    /**
     * 日志名称
     *
     * @return
     */
    String description();

    /**
     * 售后SN
     *
     * @return
     */
    String sn();


    /**
     *
     * @return 售后状态
     */
    String serviceStatus() default "";

}
