package org.duku.mall.framework.starter.common.modules.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.payment.entity.dos.RefundLog;
import org.duku.mall.framework.starter.common.modules.payment.mapper.RefundLogMapper;
import org.duku.mall.framework.starter.common.modules.payment.service.RefundLogService;
import org.springframework.stereotype.Service;

@Service
public class RefundLogServiceImpl extends ServiceImpl <RefundLogMapper, RefundLog> implements RefundLogService {
    @Override
    public RefundLog queryByAfterSaleSn(String sn) {
        return null;
    }
}
