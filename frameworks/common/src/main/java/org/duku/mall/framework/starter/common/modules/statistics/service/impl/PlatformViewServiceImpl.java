package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.statistics.entity.dos.PlatformViewData;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.PlatformViewMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.PlatformViewService;
import org.springframework.stereotype.Service;

@Service
public class PlatformViewServiceImpl extends ServiceImpl<PlatformViewMapper, PlatformViewData> implements PlatformViewService {
}
