package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.StoreFlow;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.RefundOrderStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.RefundOrderStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class RefundOrderStatisticsServiceImpl extends ServiceImpl<RefundOrderStatisticsMapper, StoreFlow> implements RefundOrderStatisticsService {
}
