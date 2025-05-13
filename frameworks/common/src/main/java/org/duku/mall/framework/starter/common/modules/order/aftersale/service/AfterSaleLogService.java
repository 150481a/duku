package org.duku.mall.framework.starter.common.modules.order.aftersale.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSaleLog;

import java.util.List;

public interface AfterSaleLogService extends IService<AfterSaleLog> {
    /**
     * 获取售后日志
     *
     * @param sn 售后编号
     * @return 售后日志列表
     */
    List<AfterSaleLog> getAfterSaleLog(String sn);

}
