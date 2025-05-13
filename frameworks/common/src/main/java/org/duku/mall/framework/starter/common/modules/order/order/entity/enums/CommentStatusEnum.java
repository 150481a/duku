package org.duku.mall.framework.starter.common.modules.order.order.entity.enums;

public enum CommentStatusEnum {

    /**
     * 新订单，不能进行评论
     */
    NEW("新订单，不能进行评论"),
    /**
     * 未完成的评论
     */
    UNFINISHED("未完成评论"),

    /**
     * 待追评的评论信息
     */
    WAIT_CHASE("待追评评论"),

    /**
     * 已经完成评论
     */
    FINISHED("已经完成评论");

    private final String description;

    CommentStatusEnum(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
