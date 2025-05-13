package org.duku.mall.framework.starter.common.modules.order.aftersale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSaleLog;
import org.duku.mall.framework.starter.common.modules.order.aftersale.mapper.AfterSaleLogMapper;
import org.duku.mall.framework.starter.common.modules.order.aftersale.service.AfterSaleLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfterSaleLogServiceImpl extends ServiceImpl <AfterSaleLogMapper, AfterSaleLog> implements AfterSaleLogService {
    @Override
    public List<AfterSaleLog> getAfterSaleLog(String sn) {
        return List.of();
    }
}
