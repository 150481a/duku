package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberNoticeSenter;

public interface MemberNoticeSenterService extends IService<MemberNoticeSenter> {
    /**
     * 自定义保存方法
     *
     * @param memberNoticeSenter 会员消息
     * @return 操作状态
     */
    boolean customSave(MemberNoticeSenter memberNoticeSenter);
}
