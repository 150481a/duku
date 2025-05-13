package org.duku.mall.framework.starter.common.modules.im.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.ImTalk;
import org.duku.mall.framework.starter.common.modules.im.entity.params.IMTalkQueryParams;
import org.duku.mall.framework.starter.common.modules.im.entity.vo.ImTalkVO;

import java.util.List;

public interface ImTalkService extends IService<ImTalk> {
    /**
     * 获取与某人的聊天框
     *
     * @param userId1
     * @return
     */
    ImTalk getTalkByUser(String userId1);

    /**
     * 获取与某人的聊天
     * @param userId
     * @return
     */
    ImTalkVO getTalkByUserId(String userId);

    /**
     * 置顶消息
     *
     * @param id
     * @param top
     */
    void top(String id, Boolean top);

    /**
     * 禁用（前端不做展示）聊天
     *
     * @param id
     */
    void disable(String id);

    /**
     * 获取用户聊天列表
     * @return 用户聊天列表
     */
    List<ImTalkVO> getUserTalkList(IMTalkQueryParams imTalkQueryParams);

    /**
     * 获取商家聊天列表
     * @return 商家聊天列表
     */
    List<ImTalkVO> getStoreTalkList(IMTalkQueryParams imTalkQueryParams);
}
