package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.unionpay;

import org.duku.mall.framework.starter.common.modules.payment.kit.core.kit.HttpKit;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.kit.WxPayKit;

import java.util.Map;

public class UnionPayApi {

    public static String authUrl = "https://qr.95516.com/qrcGtwWeb-web/api/userAuth?version=1.0.0&redirectUrl=%s";

    public static String execution(String url, Map<String, String> params) {
        return HttpKit.getDelegate().post(url, WxPayKit.toXml(params));
    }

    /**
     * 获取用户授权 API
     *
     * @param url 回调地址，可以自定义参数 https://pay.javen.com/callback?sdk=ijpay
     * @return 银联重定向 Url
     */
    public static String buildAuthUrl(String url) {
        return String.format(authUrl, url);
    }
}
