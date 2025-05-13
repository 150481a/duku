package org.duku.mall.framework.starter.common.modules.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.sms.entity.dos.SmsReach;

import java.util.List;

public interface SmsReachService extends IService<SmsReach> {

    /**
     * 添加短信任务
     *
     * @param smsReach 短信签名
     * @param mobile   手机号
     */
    void addSmsReach(SmsReach smsReach, List<String> mobile);

}
