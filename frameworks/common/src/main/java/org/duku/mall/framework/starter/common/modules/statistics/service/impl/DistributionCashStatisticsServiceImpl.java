package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dos.DistributionCash;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.DistributionCashStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.DistributionCashStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class DistributionCashStatisticsServiceImpl extends ServiceImpl<DistributionCashStatisticsMapper, DistributionCash> implements DistributionCashStatisticsService {
}
