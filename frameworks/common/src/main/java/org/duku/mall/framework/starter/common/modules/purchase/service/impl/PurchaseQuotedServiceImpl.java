package org.duku.mall.framework.starter.common.modules.purchase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.purchase.entity.dos.PurchaseQuoted;
import org.duku.mall.framework.starter.common.modules.purchase.mapper.PurchaseQuotedMapper;
import org.duku.mall.framework.starter.common.modules.purchase.service.PurchaseQuotedService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseQuotedServiceImpl extends ServiceImpl<PurchaseQuotedMapper, PurchaseQuoted> implements PurchaseQuotedService {
}
