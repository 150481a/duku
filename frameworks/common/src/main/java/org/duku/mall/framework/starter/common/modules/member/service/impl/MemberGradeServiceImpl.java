package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberGrade;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberGradeMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberGradeService;
import org.springframework.stereotype.Service;

@Service
public class MemberGradeServiceImpl extends ServiceImpl<MemberGradeMapper, MemberGrade> implements MemberGradeService {
}
