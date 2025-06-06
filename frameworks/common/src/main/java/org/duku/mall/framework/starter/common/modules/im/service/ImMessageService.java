package org.duku.mall.framework.starter.common.modules.im.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.ImMessage;
import org.duku.mall.framework.starter.common.modules.im.entity.params.MessageQueryParams;

import java.util.List;

public interface ImMessageService extends IService<ImMessage> {

    /**
     * 阅读消息
     *
     * @param talkId 对话Id
     * @param accessToken 验证token
     */
    void read(String talkId, String accessToken);

    /**
     * 未读消息列表
     *
     * @param accessToken 验证token
     * @return 未读消息列表
     */
    List<ImMessage> unReadMessages(String accessToken);

    /**
     * 历史消息
     *
     * @param accessToken 验证token
     * @param to 接收人
     *
     * @return 历史消息列表
     */
    List<ImMessage> historyMessage(String accessToken, String to);

    /**
     * 是否有新消息
     * @param accessToken 验证token
     * @return
     */
    Boolean hasNewMessage(String accessToken);

    /**
     * 分页获取消息列表
     * @param messageQueryParams 查询条件
     * @return 消息列表
     */
    List<ImMessage> getList(MessageQueryParams messageQueryParams);

    /**
     * 获取所有未读消息
     * @return 未读数量
     */
    Long unreadMessageCount();

    /**
     * 清空所有未读消息
     */
    void cleanUnreadMessage();
}
