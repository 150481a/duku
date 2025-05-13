package org.duku.mall.framework.starter.common.modules.statistics.aop.annotation;

import org.duku.mall.framework.starter.common.modules.statistics.aop.enums.PageViewEnum;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageViewPoint {


    /**
     * 描述
     */
    PageViewEnum type();

    /**
     * 如：商品id，店铺id
     * 字段类型为string ，支持 spel语法，也可以填写
     */
    String id();
}
