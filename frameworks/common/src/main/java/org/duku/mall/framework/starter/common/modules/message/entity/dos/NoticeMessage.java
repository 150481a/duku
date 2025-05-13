package org.duku.mall.framework.starter.common.modules.message.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.duku.mall.framework.starter.convention.enums.SwitchEnum;
import org.duku.mall.framework.starter.common.modules.message.entity.enums.NoticeMessageParameterEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.hibernate.validator.constraints.Length;

@Data
@TableName("li_notice_message")
@ApiModel(value = "通知类消息模板")
public class NoticeMessage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "站内信节点")
    @NotEmpty(message = "站内信节点不能为空")
    @Length(max = 50, message = "站内信节点名称太长,不能超过50")
    private String noticeNode;

    @ApiModelProperty(value = "站内信标题")
    @NotEmpty(message = "站内信标题不能为空")
    @Length(max = 50, message = "站内信标题名称太长,不能超过50")
    private String noticeTitle;

    @ApiModelProperty(value = "站内信内容")
    @NotEmpty(message = "站内信内容不能为空")
    @Length(max = 200, message = "站内信内容名称太长，不能超过200")
    private String noticeContent;
    /**
     * @see SwitchEnum
     */
    @NotEmpty(message = "站内信状态不能为空")
    @ApiModelProperty(value = "站内信是否开启")
    private String noticeStatus;
    /**
     * @see NoticeMessageParameterEnum
     */
    @ApiModelProperty(value = "消息变量")
    @NotEmpty(message = "站内信状态不能为空")
    private String variable;
}
