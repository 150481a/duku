package org.duku.mall.framework.starter.common.modules.order.aftersale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSaleReason;
import org.duku.mall.framework.starter.common.modules.order.aftersale.mapper.AfterSaleReasonMapper;
import org.duku.mall.framework.starter.common.modules.order.aftersale.service.AfterSaleReasonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfterSaleReasonServiceImpl extends ServiceImpl <AfterSaleReasonMapper, AfterSaleReason>  implements AfterSaleReasonService {
    @Override
    public List<AfterSaleReason> afterSaleReasonList(String serviceType) {
        return List.of();
    }

    @Override
    public AfterSaleReason editAfterSaleReason(AfterSaleReason afterSaleReason) {
        return null;
    }
}
