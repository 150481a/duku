package org.duku.mall.framework.starter.common.modules.member.entity.enums;

public enum PointTypeEnum {
    /**
     * 增加
     */
    INCREASE("增加"),
    /**
     * 减少
     */
    REDUCE("减少");

    private String description;

    public String description() {
        return description;
    }

    PointTypeEnum(String description) {
        this.description = description;
    }
}
