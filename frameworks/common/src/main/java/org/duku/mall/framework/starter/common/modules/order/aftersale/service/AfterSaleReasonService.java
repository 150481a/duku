package org.duku.mall.framework.starter.common.modules.order.aftersale.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSaleReason;

import java.util.List;

public interface AfterSaleReasonService extends IService<AfterSaleReason> {

    /**
     * 获取售后原因列表
     * @param serviceType
     * @return
     */
    List<AfterSaleReason> afterSaleReasonList(String serviceType);


    /**
     * 修改售后原因
     * @param afterSaleReason 售后原因
     * @return 售后原因
     */
    AfterSaleReason editAfterSaleReason(AfterSaleReason afterSaleReason);
}
