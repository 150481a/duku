package org.duku.mall.framework.starter.common.modules.promotion.entity.enums;

public enum PromotionsApplyStatusEnum {
    /**
     * 枚举
     */
    APPLY("申请"), PASS("通过"), REFUSE("拒绝");

    private final String description;

    PromotionsApplyStatusEnum(String str) {
        this.description = str;
    }

    public String description() {
        return description;
    }
}
