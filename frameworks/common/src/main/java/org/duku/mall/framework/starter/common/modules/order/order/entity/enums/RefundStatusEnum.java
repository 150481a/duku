package org.duku.mall.framework.starter.common.modules.order.order.entity.enums;

public enum RefundStatusEnum {

    /**
     * 退款状态
     */
    ALL_REFUND("全部退款"),
    PART_REFUND("部分退款"),
    NO_REFUND("未退款"),
    REFUNDING("退款中");

    private final String description;

    RefundStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String description() {
        return this.description;
    }
}
