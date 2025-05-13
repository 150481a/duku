package org.duku.mall.framework.starter.common.modules.page.entity.enums;

public enum ArticleEnum {


    /**
     * 关于我们
     */
    ABOUT,
    /**
     * 隐私政策
     */
    PRIVACY_POLICY,
    /**
     * 用户协议
     */
    USER_AGREEMENT,
    /**
     * 证照信息
     */
    LICENSE_INFORMATION,
    /**
     * 店铺入驻
     */
    STORE_REGISTER,
    /**
     * 其他文章
     */
    OTHER;

    public String value() {
        return this.name();
    }
}
