package org.duku.mall.framework.starter.common.modules.distribution.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dos.DistributionOrder;
import org.duku.mall.framework.starter.common.modules.distribution.entity.params.DistributionOrderSearchParams;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.StoreFlow;

public interface DistributionOrderService extends IService<DistributionOrder> {

    /**
     * 获取分销订单分页
     * @param distributionOrderSearchParams 分销订单搜索参数
     * @return 分销订单分页
     */
    IPage<DistributionOrder> getDistributionOrderPage(DistributionOrderSearchParams distributionOrderSearchParams);

    /**
     * 支付订单
     * 记录分销订单
     *
     * @param orderSn 订单编号
     */
    void calculationDistribution(String orderSn);

    /**
     * 取消订单
     * 记录分销订单
     *
     * @param orderSn 订单编号
     */
    void cancelOrder(String orderSn);

    /**
     * 订单退款
     * 记录分销订单
     */
    void refundOrder(AfterSale afterSale);

    /**
     * 分销订单完成
     */
    void completeOrder(StoreFlow storeFlow);
}
