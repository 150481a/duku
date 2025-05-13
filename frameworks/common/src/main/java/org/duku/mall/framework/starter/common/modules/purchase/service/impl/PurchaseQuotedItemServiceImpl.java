package org.duku.mall.framework.starter.common.modules.purchase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.purchase.entity.dos.PurchaseQuotedItem;
import org.duku.mall.framework.starter.common.modules.purchase.mapper.PurchaseQuotedItemMapper;
import org.duku.mall.framework.starter.common.modules.purchase.service.PurchaseQuotedItemService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseQuotedItemServiceImpl extends ServiceImpl<PurchaseQuotedItemMapper, PurchaseQuotedItem> implements PurchaseQuotedItemService {
}
