package org.duku.mall.framework.starter.common.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberEvaluation;
import org.duku.mall.framework.starter.common.modules.statistics.mapper.MemberEvaluationStatisticsMapper;
import org.duku.mall.framework.starter.common.modules.statistics.service.MemberEvaluationStatisticsService;
import org.springframework.stereotype.Service;

@Service
public class MemberEvaluationStatisticsServiceImpl extends ServiceImpl<MemberEvaluationStatisticsMapper, MemberEvaluation> implements MemberEvaluationStatisticsService {
}
