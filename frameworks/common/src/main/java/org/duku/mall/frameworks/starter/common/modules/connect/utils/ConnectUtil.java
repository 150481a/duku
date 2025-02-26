package org.duku.mall.frameworks.starter.common.modules.connect.utils;

import cn.hutool.json.JSONUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.result.ResultMessage;
import org.duku.mall.frameworks.starter.cache.CachePrefix;
import org.duku.mall.frameworks.starter.cache.SingletonCache;
import org.duku.mall.frameworks.starter.common.common.security.token.Token;
import org.duku.mall.frameworks.starter.common.common.utils.ResultUtil;
import org.duku.mall.frameworks.starter.common.modules.connect.config.AuthConfig;
import org.duku.mall.frameworks.starter.common.modules.connect.config.ConnectAuthEnum;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.dto.AuthCallback;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.dto.AuthResponse;
import org.duku.mall.frameworks.starter.common.modules.connect.entity.dto.ConnectAuthUser;
import org.duku.mall.frameworks.starter.common.modules.connect.request.AuthRequest;
import org.duku.mall.frameworks.starter.common.modules.connect.request.BaseAuthQQRequest;
import org.duku.mall.frameworks.starter.common.modules.connect.request.BaseAuthWeChatPCRequest;
import org.duku.mall.frameworks.starter.common.modules.connect.request.BaseAuthWeChatRequest;
import org.duku.mall.frameworks.starter.common.modules.connect.service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class ConnectUtil {
    @Autowired
    private SingletonCache cache;
    @Autowired
    private ConnectService connectService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private ApiProperties apiProperties;
    @Autowired
    private DomainProperties domainProperties;




    static String prefix = "/buyer/passport/connect/connect/callback/";

    /**
     * 回调地址获取
     *
     * @param connectAuthEnum 用户枚举
     * @return 回调地址
     */
    String getRedirectUri(ConnectAuthEnum connectAuthEnum, String callbackUrl) {
        return callbackUrl + prefix + connectAuthEnum.getName();
    }

    /**
     * 登录回调
     * 此方法处理第三方登录回调
     * 场景：PC、WAP(微信公众号)
     *
     * @param type                类型
     * @param callback            回调参数
     * @param httpServletResponse
     * @param httpServletRequest
     * @throws IOException
     */
    public void callback(String type, AuthCallback callback, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        AuthRequest authRequest = this.getAuthRequest(type);
        AuthResponse<ConnectAuthUser> response = authRequest.login(callback);
        ResultMessage<Object> resultMessage;
        //联合登陆处理，如果响应正常，则录入响应结果到redis
        if (response.ok()) {
            ConnectAuthUser authUser = response.getData();
            try {
                Token token = connectService.unionLoginCallback(authUser, callback.getState());
                resultMessage = ResultUtil.data(token);
            } catch (ServiceException e) {
                throw new ServiceException(ResultCode.ERROR, e.getMessage());
            }
        }
        //否则录入响应结果，等待前端获取信息
        else {
            throw new ServiceException(ResultCode.ERROR, response.getMsg());
        }
        //缓存写入登录结果，300秒有效
        cache.put(CachePrefix.CONNECT_RESULT.getPrefix() + callback.getCode(), resultMessage, 300L);

        //登录设置
        ConnectSetting connectSetting = JSONUtil.toBean(settingService.get(SettingEnum.CONNECT_SETTING.name()).getSettingValue(), ConnectSetting.class);

        //跳转地址
        String url = this.check(httpServletRequest.getHeader("user-agent")) ?
                connectSetting.getWap() + "/pages/passport/login?state=" + callback.getCode() :
                connectSetting.getPc() + "/login?state=" + callback.getCode();

        try {
            httpServletResponse.sendRedirect(url);
        } catch (Exception e) {
            log.error("登录回调错误", e);
        }
    }

    /**
     * 获取响应结果
     *
     * @param state
     * @return
     */
    public ResultMessage<Object> getResult(String state) {
        Object object = cache.get(CachePrefix.CONNECT_RESULT.getPrefix() + state);
        if (object == null) {
            return null;
        } else {
            cache.remove(CachePrefix.CONNECT_RESULT.getPrefix() + state);
            return (ResultMessage<Object>) object;
        }
    }

    /**
     * 联合登录
     *
     * @param type 枚举
     * @return
     */
    public AuthRequest getAuthRequest(String type) {
        ConnectAuthEnum authInterface = ConnectAuthEnum.valueOf(type);
        if (authInterface == null) {
            throw new ServiceException(ResultCode.CONNECT_NOT_EXIST);
        }
        AuthRequest authRequest = null;
        switch (authInterface) {
            case WECHAT: {
                //寻找配置
                Setting setting = settingService.get(SettingEnum.WECHAT_CONNECT.name());
                WechatConnectSetting wechatConnectSetting = JSONUtil.toBean(setting.getSettingValue(), WechatConnectSetting.class);
                //登录设置
                ConnectSetting connectSetting = JSONUtil.toBean(settingService.get(SettingEnum.CONNECT_SETTING.name()).getSettingValue(), ConnectSetting.class);

                for (WechatConnectSettingItem wechatConnectSettingItem : wechatConnectSetting.getWechatConnectSettingItems()) {
                    if (wechatConnectSettingItem.getClientType().equals(ClientTypeEnum.H5.name())) {
                        authRequest = new BaseAuthWeChatRequest(AuthConfig.builder()
                                .clientId(wechatConnectSettingItem.getAppId())
                                .clientSecret(wechatConnectSettingItem.getAppSecret())
                                .redirectUri(getRedirectUri(authInterface, connectSetting.getCallbackUrl()))
                                .build(), cache);
                    }
                }
                break;
            }
            case WECHAT_PC: {
                //寻找配置
                Setting setting = settingService.get(SettingEnum.WECHAT_CONNECT.name());
                WechatConnectSetting wechatConnectSetting = JSONUtil.toBean(setting.getSettingValue(), WechatConnectSetting.class);
                //登录设置
                ConnectSetting connectSetting = JSONUtil.toBean(settingService.get(SettingEnum.CONNECT_SETTING.name()).getSettingValue(), ConnectSetting.class);
                for (WechatConnectSettingItem wechatConnectSettingItem : wechatConnectSetting.getWechatConnectSettingItems()) {
                    if (wechatConnectSettingItem.getClientType().equals(ClientTypeEnum.PC.name())) {
                        authRequest = new BaseAuthWeChatPCRequest(AuthConfig.builder()
                                .clientId(wechatConnectSettingItem.getAppId())
                                .clientSecret(wechatConnectSettingItem.getAppSecret())
                                .redirectUri(getRedirectUri(authInterface, connectSetting.getCallbackUrl()))
                                .build(), cache);
                    }
                }

                break;
            }
            case QQ:
                //寻找配置
                Setting setting = settingService.get(SettingEnum.QQ_CONNECT.name());
                QQConnectSetting qqConnectSetting = JSONUtil.toBean(setting.getSettingValue(), QQConnectSetting.class);
                //登录设置
                ConnectSetting connectSetting = JSONUtil.toBean(settingService.get(SettingEnum.CONNECT_SETTING.name()).getSettingValue(), ConnectSetting.class);
                for (QQConnectSettingItem qqConnectSettingItem : qqConnectSetting.getQqConnectSettingItemList()) {
                    if (qqConnectSettingItem.getClientType().equals(ClientTypeEnum.PC.name())) {
                        authRequest = new BaseAuthQQRequest(AuthConfig.builder()
                                .clientId(qqConnectSettingItem.getAppId())
                                .clientSecret(qqConnectSettingItem.getAppKey())
                                .redirectUri(getRedirectUri(authInterface, connectSetting.getCallbackUrl()))
                                //这里qq获取unionid 需要配置为true，详情可以查阅属性说明，内部有帮助文档
                                .unionId(true)
                                .build(), cache);
                    }
                }

                break;
            default:
                break;
        }
        if (null == authRequest) {
            throw new AuthException("暂不支持第三方登陆");
        }
        return authRequest;
    }

    /**
     * \b 是单词边界(连着的两个(字母字符 与 非字母字符) 之间的逻辑上的间隔),
     * 字符串在编译时会被转码一次,所以是 "\\b"
     * \B 是单词内部逻辑间隔(连着的两个字母字符之间的逻辑上的间隔)
     */
    static String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"
            + "|windows (phone|ce)|blackberry"
            + "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"
            + "|laystation portable)|nokia|fennec|htc[-_]"
            + "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    static String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    /**
     * 移动设备正则匹配：手机端、平板
     */
    static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
    static Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);

    /**
     * 检测是否是移动设备访问
     *
     * @param userAgent 浏览器标识
     * @return true:移动设备接入，false:pc端接入
     * @Title: check
     */
    private boolean check(String userAgent) {
        if (null == userAgent) {
            userAgent = "";
        }
        //匹配
        Matcher matcherPhone = phonePat.matcher(userAgent);
        Matcher matcherTable = tablePat.matcher(userAgent);
        if (matcherPhone.find() || matcherTable.find()) {
            return true;
        } else {
            return false;
        }
    }
}
