package org.duku.mall.framework.starter.common.modules.message.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.message.entity.enums.NoticeMessageNodeEnum;

import java.util.Map;

@Data
public class NoticeMessageDTO {

    @ApiModelProperty(value = "会员ID")
    private String memberId;

    @ApiModelProperty(value = "消息节点")
    private NoticeMessageNodeEnum noticeMessageNodeEnum;

    @ApiModelProperty(value = "消息参数")
    private Map<String,String> parameter;
}
