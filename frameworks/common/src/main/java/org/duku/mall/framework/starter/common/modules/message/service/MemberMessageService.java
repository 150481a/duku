package org.duku.mall.framework.starter.common.modules.message.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.MemberMessage;
import org.duku.mall.framework.starter.common.modules.message.entity.vo.MemberMessageQueryVO;

import java.util.List;

public interface MemberMessageService extends IService<MemberMessage> {

    /**
     * 会员消息查询接口
     *
     * @param memberMessageQueryVO 会员查询条件
     * @param pageVO               分页条件
     * @return 会员消息分页
     */
    IPage<MemberMessage> getPage(MemberMessageQueryVO memberMessageQueryVO, PageVO pageVO);

    /**
     * 修改会员消息状态
     *
     * @param status    状态
     * @param messageId 消息id
     * @return 操作状态
     */
    Boolean editStatus(String status, String messageId);

    /**
     * 删除消息
     *
     * @param messageId 消息id
     * @return 操作状态
     */
    Boolean deleteMessage(String messageId);


    /**
     * 保存消息信息
     *
     * @param messages 消息
     * @return
     */
    boolean save(List<MemberMessage> messages);
}
