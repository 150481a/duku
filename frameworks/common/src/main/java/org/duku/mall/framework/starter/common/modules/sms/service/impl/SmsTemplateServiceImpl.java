package org.duku.mall.framework.starter.common.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.sms.entity.dos.SmsTemplate;
import org.duku.mall.framework.starter.common.modules.sms.mapper.SmsTemplateMapper;
import org.duku.mall.framework.starter.common.modules.sms.service.SmsTemplateService;
import org.springframework.stereotype.Service;

@Service
public class SmsTemplateServiceImpl extends ServiceImpl<SmsTemplateMapper, SmsTemplate> implements SmsTemplateService {
}
