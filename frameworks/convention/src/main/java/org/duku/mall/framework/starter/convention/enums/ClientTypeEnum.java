package org.duku.mall.framework.starter.convention.enums;

public enum ClientTypeEnum {
    /**
     * "移动端"
     */
    H5("移动端"),
    /**
     * "PC端"
     */
    PC("PC端"),
    /**
     * "小程序端"
     */
    WECHAT_MP("小程序端"),
    /**
     * "移动应用端"
     */
    APP("移动应用端"),
    /**
     * "未知"
     */
    UNKNOWN("未知");

    private String clientName;

    ClientTypeEnum(String des) {
        this.clientName = des;
    }

    public String clientName() {
        return this.clientName;
    }

    public String value() {
        return this.name();
    }
}
