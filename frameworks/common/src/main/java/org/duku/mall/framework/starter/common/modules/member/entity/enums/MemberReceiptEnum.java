package org.duku.mall.framework.starter.common.modules.member.entity.enums;

public enum MemberReceiptEnum {
    /**
     * 发票类型
     */
    ELECTRONIC_INVOICE("电子发票"),
    ORDINARY_INVOICE("普通发票");

    private String description;

    MemberReceiptEnum(String str) {
        this.description = str;

    }

    public String description() {
        return description;
    }
}
