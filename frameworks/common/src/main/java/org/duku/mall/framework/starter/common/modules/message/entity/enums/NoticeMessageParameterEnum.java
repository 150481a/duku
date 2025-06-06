package org.duku.mall.framework.starter.common.modules.message.entity.enums;

public enum NoticeMessageParameterEnum {

    /**
     * 商品名称
     */
    GOODS("goods", "商品名称"),
    /**
     * 消费积分
     */
    EXPENDITURE_POINTS("expenditure_points", "消费积分"),
    /**
     * 获得积分
     */
    INCOME_POINTS("income_points", "获得积分"),
    /**
     * 支出金额
     */
    EXPENDITURE("expenditure", "支出金额"),
    /**
     * 收入金额
     */
    INCOME("income", "收入金额"),
    /**
     * 拒绝原因
     */
    REFUSE("refuse", "拒绝原因"),
    /**
     * 取消原因
     */
    CANCEL_REASON("cancel_reason", "取消原因"),
    /**
     * 金额
     */
    PRICE("price", "金额");

    private final String type;
    private final String description;

    NoticeMessageParameterEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }

    /**
     * 根据type获取去value
     *
     * @param type
     * @return
     */
    public static String getValueByType(String type) {
        for (NoticeMessageParameterEnum noticeMessageParameterEnum : NoticeMessageParameterEnum.values()) {
            if (type.toLowerCase().equals(noticeMessageParameterEnum.getType().toLowerCase())) {
                return noticeMessageParameterEnum.getDescription();
            }
        }
        return null;
    }


    public String getType() {
        return type;
    }


    public String getDescription() {
        return description;
    }
}
