package org.duku.mall.framework.starter.common.modules.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.FreightTemplate;
import org.springframework.cache.annotation.CacheConfig;

@CacheConfig(cacheNames = "{freightTemplate}")
public interface FreightTemplateService extends IService<FreightTemplate> {
}
