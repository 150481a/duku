package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberNotice;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberNoticeMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberNoticeService;
import org.springframework.stereotype.Service;

@Service
public class MemberNoticeServiceImpl extends ServiceImpl<MemberNoticeMapper, MemberNotice> implements MemberNoticeService {
}
