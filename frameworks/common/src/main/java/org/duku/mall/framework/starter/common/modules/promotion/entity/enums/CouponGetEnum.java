package org.duku.mall.framework.starter.common.modules.promotion.entity.enums;

public enum CouponGetEnum {
    /**
     * 枚举
     */
    FREE("免费获取"), ACTIVITY("活动获取");

    private final String description;

    CouponGetEnum(String str) {
        this.description = str;
    }

    public String description() {
        return description;
    }

}
