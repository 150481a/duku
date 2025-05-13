package org.duku.mall.framework.starter.common.modules.good.entity.enums;

public enum GoodsSalesModeEnum {

    RETAIL("零售"),
    WHOLESALE("批发");

    private final String description;

    GoodsSalesModeEnum(String description) {
        this.description = description;

    }

    public String description() {
        return description;
    }
}
