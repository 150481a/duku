package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberNoticeLog;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberNoticeLogMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberNoticeLogService;
import org.springframework.stereotype.Service;

@Service
public class MemberNoticeLogServiceImpl extends ServiceImpl<MemberNoticeLogMapper, MemberNoticeLog> implements MemberNoticeLogService {
}
