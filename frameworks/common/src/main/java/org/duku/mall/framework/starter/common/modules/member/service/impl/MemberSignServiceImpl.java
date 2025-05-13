package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberSign;
import org.duku.mall.framework.starter.common.modules.member.mapper.MemberSignMapper;
import org.duku.mall.framework.starter.common.modules.member.service.MemberSignService;
import org.springframework.stereotype.Service;

@Service
public class MemberSignServiceImpl extends ServiceImpl<MemberSignMapper, MemberSign> implements MemberSignService {
}
