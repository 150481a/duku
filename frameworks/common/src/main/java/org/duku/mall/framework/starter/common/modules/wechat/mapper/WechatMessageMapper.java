package org.duku.mall.framework.starter.common.modules.wechat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.duku.mall.framework.starter.common.modules.wechat.entity.dos.WechatMessage;

public interface WechatMessageMapper extends BaseMapper<WechatMessage> {
    /**
     * 删除微信消息
     */
    @Delete("delete from li_wechat_message")
    void deleteAll();
}
