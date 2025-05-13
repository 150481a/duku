package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.KanjiaActivityLog;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.KanjiaActivityLogMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.KanjiaActivityLogService;
import org.springframework.stereotype.Service;

@Service
public class KanjiaActivityLogServiceImpl extends ServiceImpl<KanjiaActivityLogMapper, KanjiaActivityLog> implements KanjiaActivityLogService {
}
