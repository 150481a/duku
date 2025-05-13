package org.duku.mall.framework.starter.common.modules.message.entity.enums;

public enum MessageSendClient {
    //全部用户
    MEMBER("会员"),
    //指定用户
    STORE("店铺");

    private final String description;

    MessageSendClient(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
