package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;
import org.duku.mall.framework.starter.common.modules.statistics.entity.params.StatisticsQueryParam;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.AfterSaleStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.AfterSaleStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class AfterSaleStatisticsServiceImpl extends ServiceImpl<AfterSaleStatisticsMapper, AfterSale> implements AfterSaleStatisticsService {
    @Override
    public long applyNum(String serviceType) {
        return 0;
    }

    @Override
    public IPage<AfterSale> getStatistics(StatisticsQueryParam statisticsQueryParam, PageVO pageVO) {
        return null;
    }
}
