package org.duku.mall.framework.starter.common.modules.promotion.entity.enums;

public enum CouponRangeDayEnum {
    /**
     * 枚举
     */
    FIXEDTIME("固定时间"), DYNAMICTIME("动态时间");

    private final String description;

    CouponRangeDayEnum(String str) {
        this.description = str;
    }

    public String description() {
        return description;
    }

    public static boolean exist(String name) {
        try {
            CouponRangeDayEnum.valueOf(name);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
