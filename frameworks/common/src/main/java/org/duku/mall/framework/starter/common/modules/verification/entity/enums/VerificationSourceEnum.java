package org.duku.mall.framework.starter.common.modules.verification.entity.enums;

public enum VerificationSourceEnum {
    /**
     * 滑块
     */
    SLIDER("滑块"),
    /**
     * 验证码源
     */
    RESOURCE("验证码源");

    private final String description;

    VerificationSourceEnum(String des) {
        this.description = des;
    }
}
