package org.duku.mall.framework.starter.common.modules.store.entity.enums;

public enum BillStatusEnum {

    /**
     * "已出账"
     */
    OUT("已出账"),
    /**
     * "已核对"
     */
    CHECK("已核对"),
    /**
     * "已完成"
     */
    COMPLETE("已完成");
    private final String description;

    BillStatusEnum(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
