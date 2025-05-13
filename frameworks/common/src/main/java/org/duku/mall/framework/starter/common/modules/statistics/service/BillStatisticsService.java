package org.duku.mall.framework.starter.common.modules.statistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Bill;
import org.duku.mall.framework.starter.common.modules.store.entity.enums.BillStatusEnum;

public interface BillStatisticsService extends IService<Bill> {

    /**
     * 商家待结算数量
     *
     * @param billStatusEnum 结算单类型
     * @return 待结算商家数量
     */
    long billNum(BillStatusEnum billStatusEnum);
}
