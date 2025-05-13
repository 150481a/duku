package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.OrderStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.OrderStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class OrderStatisticsServiceImpl extends ServiceImpl<OrderStatisticsMapper, Order> implements OrderStatisticsService {
}
