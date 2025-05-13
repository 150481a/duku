package org.duku.mall.framework.starter.common.modules.good.entity.enums;

public enum GoodsStatusEnum {

    /**
     * 上架
     */
    UPPER("上架"),
    /**
     * 下架
     */
    DOWN("下架");

    private final String description;

    GoodsStatusEnum(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
