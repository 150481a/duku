package org.duku.mall.framework.starter.common.modules.message.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.message.entity.dos.NoticeMessage;
import org.duku.mall.framework.starter.common.modules.message.entity.dto.NoticeMessageDTO;

public interface NoticeMessageService extends IService<NoticeMessage> {
    /**
     * 多条件分页获取
     *
     * @param pageVO 分页数据
     * @param type   类型
     * @return
     */
    IPage<NoticeMessage> getMessageTemplate(PageVO pageVO, String type);

    /**
     * 根据模板编码获取消息模板
     *
     * @param noticeMessageDTO 站内信消息
     */
    void noticeMessage(NoticeMessageDTO noticeMessageDTO);
}
