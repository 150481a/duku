package org.duku.mall.framework.starter.common.modules.message.entity.vo;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.Message;

@Data
@ApiModel(value = "消息")
public class MessageVO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    public LambdaQueryWrapper<Message> lambdaQueryWrapper() {
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotEmpty(title)) {
            queryWrapper.like(Message::getTitle, title);
        }
        if (StrUtil.isNotEmpty(content)) {
            queryWrapper.like(Message::getContent, content);
        }
        queryWrapper.orderByDesc(Message::getCreateTime);
        return queryWrapper;
    }
}
