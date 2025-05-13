package org.duku.mall.framework.starter.common.modules.message.entity.enums;

public enum RangeEnum {
    //全部用户
    ALL("全部"),
    //指定用户
    APPOINT("指定用户");

    private final String description;

    RangeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
