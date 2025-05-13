package org.duku.mall.framework.starter.common.modules.promotion.entity.enums;

public enum CouponTypeEnum {
    /**
     * 枚举
     */
    DISCOUNT("打折"), PRICE("减免现金");

    private final String description;

    CouponTypeEnum(String str) {
        this.description = str;
    }

    public String description() {
        return description;
    }
}
