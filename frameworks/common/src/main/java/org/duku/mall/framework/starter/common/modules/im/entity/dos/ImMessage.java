package org.duku.mall.framework.starter.common.modules.im.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.distributedid.toolkit.SnowflakeIdUtil;
import org.duku.mall.framework.starter.common.modules.im.entity.enums.MessageTypeEnum;
import org.duku.mall.framework.starter.common.modules.im.entity.vo.MessageOperation;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

import java.util.Date;

@Data
@TableName("li_im_message")
@ApiModel(value = "Im消息")
@NoArgsConstructor
@AllArgsConstructor
public class ImMessage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 发送者
     */
    private String fromUser;

    /**
     * 接收者
     */
    private String toUser;

    /**
     * 已阅
     */
    private Boolean isRead;

    /**
     * 消息类型
     */
    private MessageTypeEnum messageType;

    /**
     * 聊天id
     */
    private String talkId;

    /**
     * 消息实体
     */
    private String text;


    public ImMessage(MessageOperation messageOperation){
        this.setFromUser(messageOperation.getFrom());
        this.setMessageType(messageOperation.getMessageType());
        this.setIsRead(false);
        this.setText(messageOperation.getContext());
        this.setTalkId(messageOperation.getTalkId());
        this.setCreateTime(new Date());
        this.setToUser(messageOperation.getTo());
        this.setId(SnowflakeIdUtil.nextIdStr());
    }
}
