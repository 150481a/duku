package org.duku.mall.framework.starter.common.modules.good.entity.enums;

public enum GoodsTypeEnum {
    /**
     * "实物商品"
     */
    PHYSICAL_GOODS("实物商品"),
    /**
     * "虚拟商品"
     */
    VIRTUAL_GOODS("虚拟商品"),
    /**
     * "电子卡券"
     */
    E_COUPON("电子卡券");


    private final String description;

    GoodsTypeEnum(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
