package org.duku.mall.framework.starter.common.modules.purchase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.purchase.entity.dos.PurchaseOrderItem;
import org.duku.mall.framework.starter.common.modules.purchase.mapper.PurchaseOrderItemMapper;
import org.duku.mall.framework.starter.common.modules.purchase.service.PurchaseOrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderItemServiceImpl extends ServiceImpl<PurchaseOrderItemMapper, PurchaseOrderItem> implements PurchaseOrderItemService {
    @Override
    public boolean addPurchaseOrderItem(String purchaseOrderId, List<PurchaseOrderItem> purchaseOrderItemList) {
        return false;
    }
}
