package org.duku.mall.framework.starter.common.modules.member.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_member_notice_senter")
@ApiModel(value = "会员消息")
public class MemberNoticeSenter extends BaseEntity {

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String content;
    /**
     * 会员id
     */
    @ApiModelProperty(value = "会员id")
    private String memberIds;
    /**
     * 发送类型
     */
    @ApiModelProperty(value = "发送类型,ALL 全站，SELECT 指定会员")
    private String sendType;
}
