package org.duku.mall.framework.starter.common.modules.order.cart.entity.enums;

public enum DeliveryMethodEnum {
    /**
     * "自提"
     */
    SELF_PICK_UP("自提"),
    /**
     * "同城配送"
     */
    LOCAL_TOWN_DELIVERY("同城配送"),
    /**
     * "物流"
     */
    LOGISTICS("物流");

    private final String description;

    DeliveryMethodEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
