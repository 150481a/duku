package org.duku.mall.framework.starter.common.modules.order.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.order.trade.entity.dos.OrderLog;

import java.util.List;

public interface OrderLogService  extends IService<OrderLog> {

    /**
     * 根据订单编号获取订单日志列表
     * @param orderSn 订单编号
     * @return 订单日志列表
     */
    List<OrderLog> getOrderLog(String orderSn);
}
