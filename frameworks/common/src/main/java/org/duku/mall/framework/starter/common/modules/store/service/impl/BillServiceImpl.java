package org.duku.mall.framework.starter.common.modules.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Bill;
import org.duku.mall.framework.starter.common.modules.store.mapper.BillMapper;
import org.duku.mall.framework.starter.common.modules.store.service.BillService;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {
}
