package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberEvaluation;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberEvaluationMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberEvaluationService;
import org.springframework.stereotype.Service;

@Service
public class MemberEvaluationServiceImpl extends ServiceImpl<MemberEvaluationMapper, MemberEvaluation> implements MemberEvaluationService {
}
