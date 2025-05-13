package org.duku.mall.framework.starter.common.modules.im.entity.vo;

import lombok.Data;
import org.duku.mall.framework.starter.common.enums.OperationTypeEnum;
import org.duku.mall.framework.starter.common.modules.im.entity.enums.MessageTypeEnum;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;
@Data
public class MessageOperation {
    /**
     * 消息类型
     */
    private OperationTypeEnum operationType;
    /**
     * 与某人聊天记录
     */
    private String to;

    /**
     * 发送者
     */
    private String from;

    /**
     * 聊天id
     */
    private String talkId;

    /**
     * 消息类型
     */
    private MessageTypeEnum messageType;
    /**
     * 消息内容
     */
    private String context;

    public void setOperationType(String operationType) {
        if (!StringUtils.isEmpty(operationType)) {
            this.operationType = OperationTypeEnum.valueOf(operationType);
        }
    }

    public void setMessageType(String messageType) {
        if (!StringUtils.isEmpty(messageType)) {
            this.messageType = MessageTypeEnum.valueOf(messageType);
        }
    }
}
