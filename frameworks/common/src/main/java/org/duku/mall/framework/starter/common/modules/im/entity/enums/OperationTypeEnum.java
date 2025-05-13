package org.duku.mall.framework.starter.common.modules.im.entity.enums;

public enum OperationTypeEnum {
    /**
     * 消息类型枚举
     * <p>
     * 心跳检测
     * 发起聊天
     * 发起消息
     * 查询历史消息
     * 阅读消息
     * 查询未读消息
     */
    PING,
    CREATE,
    MESSAGE,
    HISTORY,
    READ,
    UNREAD,
}
