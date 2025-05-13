package org.duku.mall.framework.starter.common.modules.page.entity.enums;

public enum FeedbackTypeEnum {
    /**
     * 功能建议
     */
    FUNCTION,

    /**
     * 优化反馈
     */
    OPTIMIZE ,

    /**
     * 其他意见
     */
    OTHER;

    public String value() {
        return this.name();
    }
}
