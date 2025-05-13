package org.duku.mall.framework.starter.common.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.sms.entity.dos.SmsReach;
import org.duku.mall.framework.starter.common.modules.sms.mapper.SmsReachMapper;
import org.duku.mall.framework.starter.common.modules.sms.service.SmsReachService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsReachServiceImpl extends ServiceImpl<SmsReachMapper, SmsReach> implements SmsReachService {
    @Override
    public void addSmsReach(SmsReach smsReach, List<String> mobile) {

    }
}
