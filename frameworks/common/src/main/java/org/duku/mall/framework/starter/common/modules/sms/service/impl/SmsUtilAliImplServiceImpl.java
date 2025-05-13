package org.duku.mall.framework.starter.common.modules.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.xkcoding.http.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.utils.CommonUtil;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.duku.mall.framework.starter.common.modules.verification.entity.enums.VerificationEnums;
import org.duku.mall.framework.starter.common.modules.sms.service.SmsUtil;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Setting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.SmsSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.enums.SettingEnum;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.user.core.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class SmsUtilAliImplServiceImpl implements SmsUtil {
    @Autowired
    private SingletonCache cache;
    @Autowired
    private SettingService settingService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private SmsPluginFactory smsPluginFactory;

    @Override
    public void sendSmsCode(String mobile, VerificationEnums verificationEnums, String uuid) {
        //获取短信配置
        Setting setting = settingService.get(SettingEnum.SMS_SETTING.name());
        if (StrUtil.isBlank(setting.getSettingValue())) {
            throw new ServiceException(ResultCode.ALI_SMS_SETTING_ERROR);
        }
        SmsSetting smsSetting = new Gson().fromJson(setting.getSettingValue(), SmsSetting.class);

        //验证码
        String code = CommonUtil.getRandomNum();

        //准备发送短信参数
        Map<String, String> params = new HashMap<>(2);
        //验证码内容
        params.put("code", code);

        //模版 默认为登录验证
        String templateCode;

        //如果某个模版需要自定义，则在此处进行调整
        switch (verificationEnums) {
            //登录
            case LOGIN: {
                templateCode = smsSetting.getLoginTemplateCode();
                break;
            }
            //注册
            case BIND_MOBILE:
            case REGISTER: {
                templateCode = smsSetting.getRegisterTemplateCode();
                break;
            }
            //找回密码
            case FIND_USER: {
                templateCode = smsSetting.getFindPasswordTemplateCode();
                break;
            }
            //修改密码
            case UPDATE_PASSWORD: {
                Member member = memberService.getById(UserContext.getCurrentUser().getUserId());
                if (member == null || StringUtil.isEmpty(member.getMobile())) {
                    return;
                }
                //更新为用户最新手机号
                mobile = member.getMobile();
                templateCode = smsSetting.getFindPasswordTemplateCode();
                break;
            }
            //设置支付密码
            case WALLET_PASSWORD: {
                Member member = memberService.getById(UserContext.getCurrentUser().getUserId());
                //更新为用户最新手机号
                mobile = member.getMobile();
                templateCode = smsSetting.getWalletPasswordTemplateCode();
                break;
            }
            //如果不是有效的验证码手段，则此处不进行短信操作
            default:
                return;
        }
        //如果是测试模式 默认验证码 6个1
        if (smsSetting.getIsTestModel()) {
            code = "111111";
            log.info("测试模式 - 接收手机：{},验证码：{}", mobile, code);
        } else {
            log.info("接收手机：{},验证码：{}", mobile, code);
            //发送短信
            smsPluginFactory.smsPlugin().sendSmsCode(smsSetting.getSignName(), mobile, params, templateCode);
        }
        //缓存中写入要验证的信息
        cache.put(cacheKey(verificationEnums, mobile, uuid), code, 300L);
    }

    @Override
    public boolean verifyCode(String mobile, VerificationEnums verificationEnums, String uuid, String code) {
        Object result = cache.get(cacheKey(verificationEnums, mobile, uuid));
        if (code.equals(result) || code.equals("0")) {
            //校验之后，删除
            cache.remove(cacheKey(verificationEnums, mobile, uuid));
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void sendBatchSms(String signName, List<String> mobile, String templateCode) {
        smsPluginFactory.smsPlugin().sendBatchSms(signName, mobile, templateCode);
    }


    /**
     * 生成缓存key
     *
     * @param verificationEnums 验证场景
     * @param mobile            手机号码
     * @param uuid              用户标识 uuid
     * @return
     */
    static String cacheKey(VerificationEnums verificationEnums, String mobile, String uuid) {
        return CachePrefix.SMS_CODE.getPrefix() + verificationEnums.name() + uuid + mobile;
    }
}
