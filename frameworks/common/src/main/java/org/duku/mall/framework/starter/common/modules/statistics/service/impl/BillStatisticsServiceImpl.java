package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.BillStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.BillStatisticsService;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Bill;
import org.duku.mall.framework.starter.common.modules.store.entity.enums.BillStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class BillStatisticsServiceImpl extends ServiceImpl<BillStatisticsMapper, Bill> implements BillStatisticsService {
    @Override
    public long billNum(BillStatusEnum billStatusEnum) {
        return 0;
    }
}
