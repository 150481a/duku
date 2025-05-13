package org.duku.mall.framework.starter.common.modules.promotion.entity.enums;

public enum CouponActivityTypeEnum {
    /**
     * "新人赠券"
     */
    REGISTERED("新人赠券"),
    /**
     * "邀新赠券"
     */
    INVITE_NEW("邀新赠券"),
    /**
     * "自动赠券"
     */
    AUTO_COUPON("自动赠券"),
    /**
     * "定向发券"
     */
    SPECIFY("精确发券");

    private final String description;

    CouponActivityTypeEnum(String str) {
        this.description = str;
    }

    public String description() {
        return description;
    }

}
