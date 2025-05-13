package org.duku.mall.framework.starter.common.modules.verification.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.common.modules.verification.entity.dos.VerificationSource;
import org.duku.mall.framework.starter.common.modules.verification.entity.dto.VerificationDTO;

public interface VerificationSourceService extends IService<VerificationSource> {

    /**
     * 缓存
     */
    String VERIFICATION_CACHE = CachePrefix.VERIFICATION.getPrefix();


    /**
     * 初始化缓存
     *
     * @return
     */
    VerificationDTO initCache();

    /**
     * 获取验证缓存
     *
     * @return 验证码
     */
    VerificationDTO getVerificationCache();
}
