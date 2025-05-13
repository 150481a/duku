package org.duku.mall.framework.starter.common.modules.page.entity.enums;

public enum PageEnum {
    /**
     * 首页
     */
    INDEX,

    /**
     * 店铺
     */
    STORE,

    /**
     * 专题页面
     */
    SPECIAL;

    public String value() {
        return this.name();
    }
}
