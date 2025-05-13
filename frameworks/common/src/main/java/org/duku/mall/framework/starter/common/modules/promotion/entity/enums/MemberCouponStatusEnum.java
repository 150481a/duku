package org.duku.mall.framework.starter.common.modules.promotion.entity.enums;

public enum MemberCouponStatusEnum {
    /**
     * 枚举
     */
    NEW("领取"), USED("已使用"), EXPIRE("过期"), CLOSED("作废");

    private final String description;

    MemberCouponStatusEnum(String str) {
        this.description = str;
    }

    public String description() {
        return description;
    }
}
