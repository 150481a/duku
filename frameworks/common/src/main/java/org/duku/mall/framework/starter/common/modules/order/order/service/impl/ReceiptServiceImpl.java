package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Receipt;
import org.duku.mall.framework.starter.common.modules.order.order.mapper.ReceiptMapper;
import org.duku.mall.framework.starter.common.modules.order.order.service.ReceiptService;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl extends ServiceImpl<ReceiptMapper, Receipt> implements ReceiptService {
}
