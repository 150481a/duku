package org.duku.mall.framework.starter.common.modules.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.payment.entity.dos.RefundLog;

public interface RefundLogService extends IService<RefundLog> {

    /**
     * 根据售后sn查询退款日志
     * @param sn
     * @return
     */
    RefundLog queryByAfterSaleSn(String sn);
}
