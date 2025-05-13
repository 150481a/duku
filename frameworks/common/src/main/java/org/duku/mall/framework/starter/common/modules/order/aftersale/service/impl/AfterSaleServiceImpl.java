package org.duku.mall.framework.starter.common.modules.order.aftersale.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dto.AfterSaleDTO;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.params.AfterSaleSearchParams;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.vo.AfterSaleApplyVO;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.vo.AfterSaleVO;
import org.duku.mall.framework.starter.common.modules.order.aftersale.mapper.AfterSaleMapper;
import org.duku.mall.framework.starter.common.modules.order.aftersale.service.AfterSaleService;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderItemService;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderService;
import org.duku.mall.framework.starter.common.modules.order.trade.entity.dto.StoreAfterSaleAddressDTO;
import org.duku.mall.framework.starter.common.modules.payment.kit.RefundSupport;
import org.duku.mall.framework.starter.common.modules.store.service.StoreDetailService;
import org.duku.mall.framework.starter.common.modules.system.entity.vo.Traces;
import org.duku.mall.framework.starter.common.modules.system.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AfterSaleServiceImpl extends ServiceImpl <AfterSaleMapper, AfterSale>  implements AfterSaleService  {


    /**
     * 订单
     */
    @Autowired
    private OrderService orderService;
    /**
     * 订单货物
     */
    @Autowired
    private OrderItemService orderItemService;
    /**
     * 物流公司
     */
    @Autowired
    private LogisticsService logisticsService;
    /**
     * 店铺详情
     */
    @Autowired
    private StoreDetailService storeDetailService;
    /**
     * 售后支持，这里用于退款操作
     */
    @Autowired
    private RefundSupport refundSupport;
    /**
     * RocketMQ配置
     */
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;
    /**
     * RocketMQ
     */
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public IPage<AfterSaleVO> getAfterSalePages(AfterSaleSearchParams saleSearchParams) {
        return null;
    }

    @Override
    public List<AfterSale> exportAfterSaleOrder(AfterSaleSearchParams saleSearchParams) {
        return List.of();
    }

    @Override
    public AfterSaleVO getAfterSale(String sn) {
        return null;
    }

    @Override
    public AfterSaleApplyVO getAfterSaleVO(String sn) {
        return null;
    }

    @Override
    public AfterSale saveAfterSale(AfterSaleDTO afterSaleDTO) {
        return null;
    }

    @Override
    public AfterSale review(String afterSaleSn, String serviceStatus, String remark, Double actualRefundPrice) {
        return null;
    }

    @Override
    public AfterSale buyerDelivery(String afterSaleSn, String logisticsNo, String logisticsId, Date mDeliverTime) {
        return null;
    }

    @Override
    public Traces deliveryTraces(String afterSaleSn) {
        return null;
    }

    @Override
    public AfterSale storeConfirm(String afterSaleSn, String serviceStatus, String remark) {
        return null;
    }

    @Override
    public AfterSale refund(String afterSaleSn, String remark) {
        return null;
    }

    @Override
    public AfterSale complete(String afterSaleSn) {
        return null;
    }

    @Override
    public AfterSale cancel(String afterSaleSn) {
        return null;
    }

    @Override
    public StoreAfterSaleAddressDTO getStoreAfterSaleAddressDTO(String sn) {
        return null;
    }
}
