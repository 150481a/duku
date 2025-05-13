package org.duku.mall.framework.starter.common.modules.verification.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.duku.mall.framework.starter.common.modules.verification.aop.annotaion.Verification;
import org.duku.mall.framework.starter.common.modules.verification.entity.enums.VerificationEnums;
import org.duku.mall.framework.starter.common.modules.verification.service.VerificationService;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Aspect
@Configuration
@Slf4j
public class VerificationInterceptor {
    @Autowired
    private VerificationService verificationService;

    @Before("@annotation(org.duku.mall.framework.starter.common.modules.verification.aop.annotation.Verification)")
    public void interceptor(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Verification verificationAnnotation = method.getAnnotation(Verification.class);
        VerificationEnums verificationEnums = verificationAnnotation.type();
        String uuid = verificationAnnotation.uuid();
        boolean result = verificationService.check(uuid, verificationEnums);
        if (result) {
            return;
        }
        throw new ServiceException(ResultCode.VERIFICATION_ERROR);
    }
}
