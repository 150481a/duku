package org.duku.mall.framework.starter.common.modules.order.trade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.trade.entity.dos.OrderLog;
import org.duku.mall.framework.starter.common.modules.order.trade.mapper.OrderLogMapper;
import org.duku.mall.framework.starter.common.modules.order.trade.service.OrderLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLogServiceImpl extends ServiceImpl<OrderLogMapper, OrderLog> implements OrderLogService {
    @Override
    public List<OrderLog> getOrderLog(String orderSn) {
        return List.of();
    }
}
