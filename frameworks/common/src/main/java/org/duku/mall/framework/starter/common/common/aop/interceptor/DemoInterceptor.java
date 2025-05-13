package org.duku.mall.framework.starter.common.common.aop.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.common.common.aop.annotation.DemoSite;
import org.duku.mall.framework.starter.common.common.properties.SystemSettingProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoInterceptor {

    @Autowired
    private SystemSettingProperties systemSettingProperties;

    @Before("@annotation(demoSite)")
    public void doAfter(DemoSite demoSite) {
        if (Boolean.TRUE.equals(systemSettingProperties.getIsDemoSite())) {
            throw new ServiceException(ResultCode.DEMO_SITE_EXCEPTION);
        }
    }


}
