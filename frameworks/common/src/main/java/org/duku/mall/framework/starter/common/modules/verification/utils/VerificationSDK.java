package org.duku.mall.framework.starter.common.modules.verification.utils;

import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificationSDK {

    @Autowired
    private SingletonCache cache;

    /**
     * 生成一个token 用于获取校验中心的验证码逻辑
     *
     * @return
     */
    public boolean checked(String verificationKey, String uuid) {
        //生成校验KEY，在验证码服务做记录
        String key = CachePrefix.VERIFICATION_KEY.getPrefix() + verificationKey;
        cache.get(key);
        return true;
    }
}
