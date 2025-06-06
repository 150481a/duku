package org.duku.mall.framework.starter.common.modules.order.order.entity.enums;

public enum PromotionsStatusEnum {

    /**
     * 新建
     */
    NEW("新建"),
    /**
     * 开始/上架
     */
    START("开始/上架"),
    /**
     * 结束/下架
     */
    END("结束/下架"),
    /**
     * 紧急关闭/作废
     */
    CLOSE("紧急关闭/作废");

    private final String description;

    PromotionsStatusEnum(String str) {
        this.description = str;
    }

    public String description() {
        return description;
    }
}
