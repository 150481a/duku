package org.duku.mall.framework.starter.common.modules.promotion.entity.enums;

public enum CouponFrequencyEnum {
    /**
     * 领取周期
     */
    DAY("每天"), WEEK("每周"), MONTH("每月");

    private final String description;

    CouponFrequencyEnum(String str) {
        this.description = str;
    }

    public String description() {
        return description;
    }

    public static boolean exist(String name) {
        if (name == null) {
            return false;
        }
        try {
            CouponFrequencyEnum.valueOf(name);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
