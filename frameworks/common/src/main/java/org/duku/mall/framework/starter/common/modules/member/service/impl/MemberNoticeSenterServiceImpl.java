package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberNoticeSenter;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberNoticeSenterMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberNoticeSenterService;
import org.springframework.stereotype.Service;

@Service
public class MemberNoticeSenterServiceImpl extends ServiceImpl<MemberNoticeSenterMapper, MemberNoticeSenter> implements MemberNoticeSenterService {
    @Override
    public boolean customSave(MemberNoticeSenter memberNoticeSenter) {
        return false;
    }
}
