package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderPackageItem;
import org.duku.mall.framework.starter.common.modules.order.order.mapper.OrderPackageItemMapper;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderPackageItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPackageItemServiceImpl extends ServiceImpl<OrderPackageItemMapper, OrderPackageItem> implements OrderPackageItemService {
    @Override
    public List<OrderPackageItem> getOrderPackageItemListByOrderSn(String orderSn) {
        return List.of();
    }

    @Override
    public List<OrderPackageItem> getOrderPackageItemListByPno(String packageNo) {
        return List.of();
    }
}
