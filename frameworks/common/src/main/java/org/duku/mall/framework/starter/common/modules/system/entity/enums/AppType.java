package org.duku.mall.framework.starter.common.modules.system.entity.enums;

public enum AppType {

    /**
     * IOS
     */
    IOS("IOS"),
    /**
     * 安卓
     */
    ANDROID("安卓");

    private final String description;

    AppType(String description) {
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public String description() {
        return this.description;
    }
}
