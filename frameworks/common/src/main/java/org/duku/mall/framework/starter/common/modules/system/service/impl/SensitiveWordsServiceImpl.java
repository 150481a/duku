package org.duku.mall.framework.starter.common.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.SensitiveWords;
import org.duku.mall.framework.starter.common.modules.system.mapper.SensitiveWordsMapper;
import org.duku.mall.framework.starter.common.modules.system.service.SensitiveWordsService;
import org.springframework.stereotype.Service;

@Service
public class SensitiveWordsServiceImpl extends ServiceImpl<SensitiveWordsMapper, SensitiveWords> implements SensitiveWordsService {
}
