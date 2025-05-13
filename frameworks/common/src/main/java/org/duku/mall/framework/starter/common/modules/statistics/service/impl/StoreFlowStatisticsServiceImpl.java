package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.StoreFlow;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.StoreFlowStatisticsServiceMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.StoreFlowStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class StoreFlowStatisticsServiceImpl extends ServiceImpl<StoreFlowStatisticsServiceMapper, StoreFlow> implements StoreFlowStatisticsService {
}
