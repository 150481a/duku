package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.MemberAddressDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.TradeDTO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dto.OrderMessage;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dto.PartDeliveryParamsDTO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.params.OrderSearchParams;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderDetailVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderSimpleVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.PaymentLog;
import org.duku.mall.framework.starter.common.modules.order.order.mapper.OrderMapper;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderService;
import org.duku.mall.framework.starter.common.modules.system.entity.vo.Traces;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Override
    public void systemCancel(String orderSn, String reason, Boolean refundMoney) {

    }

    @Override
    public Order getBySn(String orderSn) {
        return null;
    }

    @Override
    public IPage<OrderSimpleVO> queryByParams(OrderSearchParams orderSearchParams) {
        return null;
    }

    @Override
    public List<Order> queryListByParams(OrderSearchParams orderSearchParams) {
        return List.of();
    }

    @Override
    public List<Order> queryListByPromotion(String orderPromotionType, String payStatus, String parentOrderSn, String orderSn) {
        return List.of();
    }

    @Override
    public long queryCountByPromotion(String orderPromotionType, String payStatus, String parentOrderSn, String orderSn) {
        return 0;
    }

    @Override
    public List<Order> queryListByPromotion(String pintuanId) {
        return List.of();
    }

    @Override
    public void queryExportOrder(HttpServletResponse response, OrderSearchParams orderSearchParams) {

    }

    @Override
    public OrderDetailVO queryDetail(String orderSn) {
        return null;
    }

    @Override
    public void intoDB(TradeDTO tradeDTO) {

    }

    @Override
    public void payOrder(String orderSn, String paymentMethod, String receivableNo) {

    }

    @Override
    public void afterOrderConfirm(String orderSn) {

    }

    @Override
    public Order cancel(String orderSn, String reason) {
        return null;
    }

    @Override
    public Order updateConsignee(String orderSn, MemberAddressDTO memberAddressDTO) {
        return null;
    }

    @Override
    public Order delivery(String orderSn, String invoiceNumber, String logisticsId) {
        return null;
    }

    @Override
    public Order shunFengDelivery(String orderSn) {
        return null;
    }

    @Override
    public Traces getTraces(String orderSn) {
        return null;
    }

    @Override
    public Traces getMapTraces(String orderSn) {
        return null;
    }

    @Override
    public Order take(String orderSn, String verificationCode) {
        return null;
    }

    @Override
    public Order take(String verificationCode) {
        return null;
    }

    @Override
    public Order getOrderByVerificationCode(String verificationCode) {
        return null;
    }

    @Override
    public void complete(String orderSn) {

    }

    @Override
    public void systemComplete(String orderSn) {

    }

    @Override
    public List<Order> getByTradeSn(String tradeSn) {
        return List.of();
    }

    @Override
    public void sendUpdateStatusMessage(OrderMessage orderMessage) {

    }

    @Override
    public void deleteOrder(String sn) {

    }

    @Override
    public Boolean invoice(String sn) {
        return null;
    }

    @Override
    public void agglomeratePintuanOrder(String pintuanId, String parentOrderSn) {

    }

    @Override
    public void getBatchDeliverList(HttpServletResponse response, List<String> logisticsName) {

    }

    @Override
    public void batchDeliver(MultipartFile files) {

    }

    @Override
    public Double getPaymentTotal(String orderSn) {
        return 0.0;
    }

    @Override
    public IPage<PaymentLog> queryPaymentLogs(IPage<PaymentLog> page, Wrapper<PaymentLog> queryWrapper) {
        return null;
    }

    @Override
    public boolean checkFictitiousOrder(String pintuanId, Integer requiredNum, Boolean fictitious) {
        return false;
    }

    @Override
    public Order partDelivery(PartDeliveryParamsDTO partDeliveryParamsDTO) {
        return null;
    }

    @Override
    public Order updateSellerRemark(String orderSn, String sellerRemark) {
        return null;
    }
}
