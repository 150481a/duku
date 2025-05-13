package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.alipay.api.domain.Goods;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.GoodsStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.GoodsStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsStatisticsServiceImpl extends ServiceImpl<GoodsStatisticsMapper, Goods> implements GoodsStatisticsService {
}
