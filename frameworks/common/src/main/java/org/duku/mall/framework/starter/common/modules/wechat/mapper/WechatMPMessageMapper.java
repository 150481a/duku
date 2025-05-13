package org.duku.mall.framework.starter.common.modules.wechat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.duku.mall.framework.starter.common.modules.wechat.entity.dos.WechatMPMessage;

public interface WechatMPMessageMapper extends BaseMapper<WechatMPMessage> {

    /**
     * 删除微信消息
     */
    @Delete("delete from li_wechat_mp_message")
    void deleteAll();
}
