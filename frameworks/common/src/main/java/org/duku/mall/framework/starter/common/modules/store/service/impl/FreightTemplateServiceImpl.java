package org.duku.mall.framework.starter.common.modules.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.FreightTemplate;
import org.duku.mall.framework.starter.common.modules.store.mapper.FreightTemplateMapper;
import org.duku.mall.framework.starter.common.modules.store.service.FreightTemplateService;
import org.springframework.stereotype.Service;

@Service
public class FreightTemplateServiceImpl extends ServiceImpl<FreightTemplateMapper, FreightTemplate> implements FreightTemplateService {
}
