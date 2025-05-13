package org.duku.mall.framework.starter.common.modules.statistics.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;
import org.duku.mall.framework.starter.common.modules.statistics.entity.params.StatisticsQueryParam;

public interface AfterSaleStatisticsService extends IService<AfterSale> {

    /**
     * 获取待处理售后数量
     *
     * @param serviceType 售后类型
     * @return 待处理售后数量
     */
    long applyNum(String serviceType);

    /**
     * 获取统计的售后
     *
     * @param statisticsQueryParam 统计搜索参数
     * @param pageVO               分页
     * @return 售后分页列表
     */
    IPage<AfterSale> getStatistics(StatisticsQueryParam statisticsQueryParam, PageVO pageVO);
}
