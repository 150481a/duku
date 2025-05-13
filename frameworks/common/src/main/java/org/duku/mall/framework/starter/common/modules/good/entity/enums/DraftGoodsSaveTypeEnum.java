package org.duku.mall.framework.starter.common.modules.good.entity.enums;

public enum DraftGoodsSaveTypeEnum {
    /**
     * "草稿"
     */
    DRAFT("草稿"),
    /**
     * "模版"
     */
    TEMPLATE("模版");

    private final String description;

    DraftGoodsSaveTypeEnum(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
