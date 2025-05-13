package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.StoreStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.StoreStatisticsService;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Store;
import org.springframework.stereotype.Service;

@Service
public class StoreStatisticsServiceImpl extends ServiceImpl<StoreStatisticsMapper, Store> implements StoreStatisticsService {
}
