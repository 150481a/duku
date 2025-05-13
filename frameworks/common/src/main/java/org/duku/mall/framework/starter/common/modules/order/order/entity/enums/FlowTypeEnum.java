package org.duku.mall.framework.starter.common.modules.order.order.entity.enums;

public enum FlowTypeEnum {

    /**
     * 流水类型
     */
    PAY("支付"),
    REFUND("退款");

    private final String description;

    FlowTypeEnum(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
