package org.duku.mall.framework.starter.common.modules.verification.aop.annotaion;

import org.duku.mall.framework.starter.common.modules.verification.entity.enums.VerificationEnums;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Verification {

    /**
     * uuid
     *
     * @return String
     */
    String uuid();

    /**
     * 验证类型
     *
     * @return
     */
    VerificationEnums type();
}
