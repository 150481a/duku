package org.duku.mall.framework.starter.common.modules.verification.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.verification.entity.dos.VerificationSource;
import org.duku.mall.framework.starter.common.modules.verification.mapper.VerificationSourceMapper;
import org.duku.mall.framework.starter.common.modules.verification.service.VerificationSourceService;
import org.springframework.stereotype.Service;

@Service
public class VerificationSourceServiceImpl extends ServiceImpl<VerificationSourceMapper, VerificationSource> implements VerificationSourceService {
}
