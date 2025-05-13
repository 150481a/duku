package org.duku.mall.framework.starter.common.modules.order.order.entity.enums;

public enum DeliverStatusEnum {
    /**
     * 发货状态
     */
    UNDELIVERED("未发货"),
    PARTS_DELIVERED("部分发货"),
    DELIVERED("已发货"),
    RECEIVED("已收货");


    private final String description;

    DeliverStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
