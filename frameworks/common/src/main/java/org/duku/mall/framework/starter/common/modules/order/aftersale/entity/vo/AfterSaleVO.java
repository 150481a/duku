package org.duku.mall.framework.starter.common.modules.order.aftersale.entity.vo;

import lombok.Data;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;

@Data
public class AfterSaleVO extends AfterSale {
    /**
     * 初始化自身状态
     */
    public AfterSaleAllowOperation getAfterSaleAllowOperationVO() {

        //设置订单的可操作状态
        return new AfterSaleAllowOperation(this);
    }
}
