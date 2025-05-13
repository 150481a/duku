package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderComplaint;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.OrderComplaintStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.OrderComplaintStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class OrderComplaintStatisticsServiceImpl extends ServiceImpl <OrderComplaintStatisticsMapper, OrderComplaint> implements OrderComplaintStatisticsService {
}
