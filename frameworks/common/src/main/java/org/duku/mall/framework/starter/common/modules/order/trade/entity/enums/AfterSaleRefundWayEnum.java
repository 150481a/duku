package org.duku.mall.framework.starter.common.modules.order.trade.entity.enums;

public enum AfterSaleRefundWayEnum {


    /**
     * "原路退回"
     */
    ORIGINAL("原路退回"),
    /**
     * "线下支付"
     */
    OFFLINE("线下支付");

    private final String description;

    AfterSaleRefundWayEnum(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
