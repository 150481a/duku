package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Trade;
import org.duku.mall.framework.starter.common.modules.order.order.mapper.TradeMapper;
import org.duku.mall.framework.starter.common.modules.order.order.service.TradeService;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl extends ServiceImpl<TradeMapper, Trade> implements TradeService {
}
