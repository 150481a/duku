package org.duku.mall.framework.starter.common.modules.order.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderPackageItem;

import java.util.List;

public interface OrderPackageItemService extends IService<OrderPackageItem> {

    /**
     * 根据订单编号获取订单包裹列表
     * @param orderSn 订单编号
     * @return 子订单包裹列表
     */
    List<OrderPackageItem> getOrderPackageItemListByOrderSn(String orderSn);


    /**
     * 根据包裹编号获取子包裹列表
     * @param packageNo 包裹编号
     * @return 子包裹列表
     */
    List<OrderPackageItem> getOrderPackageItemListByPno(String packageNo);
}
