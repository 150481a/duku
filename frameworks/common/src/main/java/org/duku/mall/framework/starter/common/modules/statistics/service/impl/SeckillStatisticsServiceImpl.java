package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Seckill;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.SeckillStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.SeckillStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class SeckillStatisticsServiceImpl extends ServiceImpl<SeckillStatisticsMapper, Seckill> implements SeckillStatisticsService {
}
