package org.duku.mall.framework.starter.common.modules.order.order.entity.enums;

public enum OrderComplaintStatusEnum {

    /**
     * 新订单，不能申请投诉
     */
    NEW("待审核"),
    /**
     * 未申请
     */
    NO_APPLY("未申请"),
    /**
     * 申请中
     */
    APPLYING("申请中"),
    /**
     * 已完成
     */
    COMPLETE("已完成"),
    /**
     * 已失效
     */
    EXPIRED("已失效"),
    /**
     * 取消
     */
    CANCEL("取消");

    private final String description;

    OrderComplaintStatusEnum(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
