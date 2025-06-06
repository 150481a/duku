package org.duku.mall.framework.starter.common.modules.im.entity.params;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.ImMessage;

@EqualsAndHashCode(callSuper = true)
@Data
public class MessageQueryParams extends PageVO {

    private static final long serialVersionUID = 3504156704697214077L;

    /**
     * 聊天窗口
     */
    private String talkId;
    /**
     * 最后一个消息
     */
    private String lastMessageId;
    /**
     * 获取消息数量
     */
    private Integer num;

    public LambdaQueryWrapper<ImMessage> initQueryWrapper() {
        if (CharSequenceUtil.isEmpty(talkId)) {
            throw new ServiceException(ResultCode.ERROR);
        }
        if (num == null || num > 50) {
            num = 50;
        }

        LambdaQueryWrapper<ImMessage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ImMessage::getTalkId, talkId);
        if (CharSequenceUtil.isNotEmpty(lastMessageId)) {
            lambdaQueryWrapper.lt(ImMessage::getId, lastMessageId);
        }
        lambdaQueryWrapper.orderByDesc(ImMessage::getCreateTime);
//        lambdaQueryWrapper.last("limit " + num);
        return lambdaQueryWrapper;
    }
}
