package org.duku.mall.framework.starter.common.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.sms.entity.dos.SmsSign;
import org.duku.mall.framework.starter.common.modules.sms.mapper.SmsSignMapper;
import org.duku.mall.framework.starter.common.modules.sms.service.SmsSignService;
import org.springframework.stereotype.Service;

@Service
public class SmsSignServiceImpl extends ServiceImpl<SmsSignMapper, SmsSign> implements SmsSignService {
}
