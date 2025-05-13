package org.duku.mall.framework.starter.common.modules.purchase.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.purchase.entity.dos.PurchaseOrderItem;

import java.util.List;

public interface PurchaseOrderItemService extends IService<PurchaseOrderItem> {

    /**
     * 添加采购单子内容
     *
     * @param purchaseOrderId       采购单ID
     * @param purchaseOrderItemList 采购单子内容列表
     * @return 操作结果
     */
    boolean addPurchaseOrderItem(String purchaseOrderId, List<PurchaseOrderItem> purchaseOrderItemList);
}
