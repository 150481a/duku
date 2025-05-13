package org.duku.mall.framework.starter.common.modules.message.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.Message;
import org.duku.mall.framework.starter.common.modules.message.entity.vo.MessageVO;

public interface MessageService extends IService<Message> {


    /**
     * 多条件分页获取
     *
     * @param messageVO
     * @param pageVO
     * @return
     */
    IPage<Message> getPage(MessageVO messageVO, PageVO pageVO);

    /**
     * 发送站内信
     *
     * @param message 站内信
     * @return
     */
    Boolean sendMessage(Message message);

    /**
     * 删除站内信
     *
     * @param id 站内信id
     * @return
     */
    Boolean deleteMessage(String id);
}
