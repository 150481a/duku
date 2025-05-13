package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.KanjiaActivity;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.KanjiaActivityMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.KanjiaActivityService;
import org.springframework.stereotype.Service;

@Service
public class KanjiaActivityServiceImpl extends ServiceImpl<KanjiaActivityMapper, KanjiaActivity> implements KanjiaActivityService {
}
