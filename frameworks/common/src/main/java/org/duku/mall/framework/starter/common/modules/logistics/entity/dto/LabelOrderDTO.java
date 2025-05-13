package org.duku.mall.framework.starter.common.modules.logistics.entity.dto;

import lombok.Data;

import java.util.List;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderItem;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.StoreLogistics;
import org.duku.mall.framework.starter.common.modules.store.entity.dto.StoreDeliverGoodsAddressDTO;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Logistics;

@Data
public class LabelOrderDTO {

    //订单
    Order order;
    //订单货物
    List<OrderItem> orderItems;
    //物流公司
    Logistics logistics;
    //店铺物流公司配置
    StoreLogistics storeLogistics;
    //店铺发件地址
    StoreDeliverGoodsAddressDTO storeDeliverGoodsAddressDTO;
}
