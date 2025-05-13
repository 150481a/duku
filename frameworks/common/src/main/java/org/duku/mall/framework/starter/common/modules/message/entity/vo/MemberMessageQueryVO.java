package org.duku.mall.framework.starter.common.modules.message.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.message.entity.enums.MessageStatusEnum;

@Data
@ApiModel(value = "会员接收消息查询vo")
public class MemberMessageQueryVO {
    private static final long serialVersionUID = 1L;

    /**
     * @see MessageStatusEnum
     */
    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "消息id")
    private String messageId;

    @ApiModelProperty(value = "消息标题")
    private String title;

    @ApiModelProperty(value = "会员id")
    private String memberId;
}
