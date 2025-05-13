package org.duku.mall.framework.starter.common.modules.distribution.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dos.DistributionOrder;
import org.duku.mall.framework.starter.common.modules.distribution.entity.params.DistributionOrderSearchParams;
import org.duku.mall.framework.starter.common.modules.distribution.mapper.DistributionOrderMapper;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionOrderService;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionService;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.StoreFlow;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderService;
import org.duku.mall.framework.starter.common.modules.order.order.service.StoreFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistributionOrderServiceImpl extends ServiceImpl<DistributionOrderMapper, DistributionOrder> implements DistributionOrderService {


    /**
     * 订单
     */
    @Autowired
    private OrderService orderService;
    /**
     * 店铺流水
     */
    @Autowired
    private StoreFlowService storeFlowService;
    /**
     * 分销员
     */
    @Autowired
    private DistributionService distributionService;

    @Override
    public IPage<DistributionOrder> getDistributionOrderPage(DistributionOrderSearchParams distributionOrderSearchParams) {
        return null;
    }

    @Override
    public void calculationDistribution(String orderSn) {

    }

    @Override
    public void cancelOrder(String orderSn) {

    }

    @Override
    public void refundOrder(AfterSale afterSale) {

    }

    @Override
    public void completeOrder(StoreFlow storeFlow) {

    }
}
