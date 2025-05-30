package org.duku.mall.framework.starter.common.modules.order.order.entity.enums;

public enum ProfitSharingStatusEnum {

    ORDER_CANCEL("订单取消"),
    WAIT_COMPLETE("待订单完成"),
    PROCESSING("处理中"),
    FINISHED("分账完成");
    //    FAIL("分账失败"),
//    ARTIFICIAL("人工处理");
    private String description;

    ProfitSharingStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
