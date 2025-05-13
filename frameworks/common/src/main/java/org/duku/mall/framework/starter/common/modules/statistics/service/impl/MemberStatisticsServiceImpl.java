package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.MemberStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.MemberStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class MemberStatisticsServiceImpl extends ServiceImpl<MemberStatisticsMapper, Member> implements MemberStatisticsService {
}
