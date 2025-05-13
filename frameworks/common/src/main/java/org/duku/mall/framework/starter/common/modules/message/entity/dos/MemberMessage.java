package org.duku.mall.framework.starter.common.modules.message.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.message.entity.enums.MessageStatusEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_member_message")
@ApiModel(value = "会员消息")
public class MemberMessage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "消息标题")
    private String title;

    @ApiModelProperty(value = "消息内容")
    private String content;

    @ApiModelProperty(value = "关联消息id")
    private String messageId;

    /**
     * @see MessageStatusEnum
     */
    @ApiModelProperty(value = "状态")
    private String status = MessageStatusEnum.UN_READY.name();
}
