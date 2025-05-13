package org.duku.mall.framework.starter.common.modules.purchase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.purchase.entity.dos.PurchaseOrder;
import org.duku.mall.framework.starter.common.modules.purchase.mapper.PurchaseOrderMapper;
import org.duku.mall.framework.starter.common.modules.purchase.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderServiceImpl extends ServiceImpl <PurchaseOrderMapper, PurchaseOrder> implements PurchaseOrderService {
}
