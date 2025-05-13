package org.duku.mall.framework.starter.common.modules.order.order.service;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderItem;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dto.OrderItemOperationDTO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.CommentStatusEnum;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.OrderComplaintStatusEnum;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.OrderItemAfterSaleStatusEnum;

import java.util.List;

public interface OrderItemService extends IService<OrderItem> {

    /**
     * 更新评论状态
     *
     * @param orderItemSn       子订单编号
     * @param commentStatusEnum 评论状态枚举
     */
    void updateCommentStatus(String orderItemSn, CommentStatusEnum commentStatusEnum);

    /**
     * 更新可申请售后状态
     *
     * @param orderItemSn                  子订单编号
     * @param orderItemAfterSaleStatusEnum 售后状态枚举
     */
    void updateAfterSaleStatus(String orderItemSn, OrderItemAfterSaleStatusEnum orderItemAfterSaleStatusEnum);

    /**
     * 更新售后状态
     * @param orderItem
     */
    void updateByAfterSale(OrderItem orderItem);

    /**
     * 更新订单可投诉状态
     *
     * @param orderSn            订单sn
     * @param skuId              商品skuId
     * @param complainId         订单交易投诉ID
     * @param complainStatusEnum 修改状态
     */
    void updateOrderItemsComplainStatus(String orderSn, String skuId, String complainId, OrderComplaintStatusEnum complainStatusEnum);

    /**
     * 根据子订单编号获取子订单信息
     *
     * @param sn 子订单编号
     * @return 子订单
     */
    OrderItem getBySn(String sn);

    /**
     * 根据订单编号获取子订单列表
     *
     * @param orderSn 订单编号
     * @return 子订单列表
     */
    List<OrderItem> getByOrderSn(String orderSn);

    /**
     * 子订单查询
     *
     * @param orderSn 订单编号
     * @param skuId   skuid
     * @return 子订单
     */
    OrderItem getByOrderSnAndSkuId(String orderSn, String skuId);

    List<OrderItem> waitOperationOrderItem(OrderItemOperationDTO orderItemOperationDTO);

    void expiredAfterSaleStatus(DateTime expiredTime);
}
