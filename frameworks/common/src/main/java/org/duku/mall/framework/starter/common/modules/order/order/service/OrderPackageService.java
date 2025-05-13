package org.duku.mall.framework.starter.common.modules.order.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderPackage;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderPackageVO;

import java.util.List;

public interface OrderPackageService extends IService<OrderPackage> {

    /**
     * 根据订单编号获取订单包裹列表
     * @param orderSn
     * @return
     */
    List<OrderPackage> orderPackageList(String orderSn);

    /**
     * 获取指定订单编号的所有包裹
     * @param orderSn
     * @return
     */
    List<OrderPackageVO> getOrderPackageVOList(String orderSn);
}
