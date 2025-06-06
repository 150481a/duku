package org.duku.mall.framework.starter.common.modules.payment.kit.core.kit;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.PaymentHttpResponse;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.enums.RequestMethodEnums;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.enums.SignType;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>微信支付工具类</p>
 *
 * @author
 */
public class WxPayKit {
    private static final String FIELD_SIGN = "sign";
    private static final String FIELD_SIGN_TYPE = "sign_type";

    public static String hmacSha256(String data, String key) {
        return PayKit.hmacSha256(data, key);
    }

    public static String md5(String data) {
        return PayKit.md5(data);
    }

    /**
     * AES 解密
     *
     * @param base64Data 需要解密的数据
     * @param key        密钥
     * @return 解密后的数据
     */
    public static String decryptData(String base64Data, String key) {
        return PayKit.decryptData(base64Data, key);
    }

    /**
     * AES 加密
     *
     * @param data 需要加密的数据
     * @param key  密钥
     * @return 加密后的数据
     */
    public static String encryptData(String data, String key) {
        return PayKit.encryptData(data, key);
    }

    public static String generateStr() {
        return IdUtil.fastSimpleUUID();
    }


    /**
     * 支付异步通知时校验 sign
     *
     * @param params     参数
     * @param partnerKey 支付密钥
     * @return {boolean}
     */
    public static boolean verifyNotify(Map<String, String> params, String partnerKey) {
        String sign = params.get("sign");
        String localSign = createSign(params, partnerKey, SignType.MD5);
        return sign.equals(localSign);
    }

    /**
     * 支付异步通知时校验 sign
     *
     * @param params     参数
     * @param partnerKey 支付密钥
     * @param signType   {@link SignType}
     * @return {@link Boolean} 验证签名结果
     */
    public static boolean verifyNotify(Map<String, String> params, String partnerKey, SignType signType) {
        String sign = params.get("sign");
        String localSign = createSign(params, partnerKey, signType);
        return sign.equals(localSign);
    }

    /**
     * 生成签名
     *
     * @param params     需要签名的参数
     * @param partnerKey 密钥
     * @param signType   签名类型
     * @return 签名后的数据
     */
    public static String createSign(Map<String, String> params, String partnerKey, SignType signType) {
        if (signType == null) {
            signType = SignType.MD5;
        }
        //生成签名前先去除sign
        params.remove(FIELD_SIGN);
        String tempStr = PayKit.createLinkString(params);
        String stringSignTemp = tempStr + "&key=" + partnerKey;
        if (signType == SignType.MD5) {
            return md5(stringSignTemp).toUpperCase();
        } else {
            return hmacSha256(stringSignTemp, partnerKey).toUpperCase();
        }
    }

    /**
     * APP 单独生成签名
     * app 支付环境中，如果遇到签名错误，百思不得其解，则可以使用这个方法调用签名尝试解决
     *
     * @param params 需要签名的参数
     * @return 签名后的数据
     */
    public static String createAppSign(Map<String, String> params, String privateKey) {

        String appid = params.get("appid");
        String timestamp = params.get("timestamp");
        String noncestr = params.get("noncestr");
        String prepayid = params.get("prepayid");

        String encrypt = appid + "\n" + timestamp + "\n" + noncestr + "\n" + prepayid + "\n";

        try {
            return PayKit.createSign(encrypt, privateKey);
        } catch (Exception e) {
            throw new ServiceException(ResultCode.ERROR);
        }
    }


    /**
     * 生成签名
     *
     * @param params 需要签名的参数
     * @param secret 企业微信支付应用secret
     * @return 签名后的数据
     */
    public static String createSign(Map<String, String> params, String secret) {
        //生成签名前先去除sign
        params.remove(FIELD_SIGN);
        String tempStr = PayKit.createLinkString(params);
        String stringSignTemp = tempStr + "&secret=" + secret;
        return md5(stringSignTemp).toUpperCase();
    }

    /**
     * 构建签名
     *
     * @param params     需要签名的参数
     * @param partnerKey 密钥
     * @param signType   签名类型
     * @return 签名后的 Map
     */
    public static Map<String, String> buildSign(Map<String, String> params, String partnerKey, SignType signType) {
        return buildSign(params, partnerKey, signType, true);
    }

    /**
     * 构建签名
     *
     * @param params       需要签名的参数
     * @param partnerKey   密钥
     * @param signType     签名类型
     * @param haveSignType 签名是否包含 sign_type 字段
     * @return 签名后的 Map
     */
    public static Map<String, String> buildSign(Map<String, String> params, String partnerKey, SignType signType, boolean haveSignType) {
        if (haveSignType) {
            params.put(FIELD_SIGN_TYPE, signType.getType());
        }
        String sign = createSign(params, partnerKey, signType);
        params.put(FIELD_SIGN, sign);
        return params;
    }

    public static StringBuffer forEachMap(Map<String, String> params, String prefix, String suffix) {
        return PayKit.forEachMap(params, prefix, suffix);
    }

    /**
     * 微信下单 map to xml
     *
     * @param params Map 参数
     * @return xml 字符串
     */
    public static String toXml(Map<String, String> params) {
        return PayKit.toXml(params);
    }

    /**
     * 针对支付的 xml，没有嵌套节点的简单处理
     *
     * @param xmlStr xml 字符串
     * @return 转化后的 Map
     */
    public static Map<String, String> xmlToMap(String xmlStr) {
        return PayKit.xmlToMap(xmlStr);
    }

    /**
     * <p>生成二维码链接</p>
     * <p>原生支付接口模式一(扫码模式一)</p>
     *
     * @param sign      签名
     * @param appId     公众账号ID
     * @param mchId     商户号
     * @param productId 商品ID
     * @param timeStamp 时间戳
     * @param nonceStr  随机字符串
     * @return {String}
     */
    public static String bizPayUrl(String sign, String appId, String mchId, String productId, String timeStamp, String nonceStr) {
        String rules = "weixin://wxpay/bizpayurl?sign=Temp&appid=Temp&mch_id=Temp&product_id=Temp&time_stamp=Temp&nonce_str=Temp";
        return replace(rules, "Temp", sign, appId, mchId, productId, timeStamp, nonceStr);
    }

    /**
     * <p>生成二维码链接</p>
     * <p>原生支付接口模式一(扫码模式一)</p>
     *
     * @param partnerKey 密钥
     * @param appId      公众账号ID
     * @param mchId      商户号
     * @param productId  商品ID
     * @param timeStamp  时间戳
     * @param nonceStr   随机字符串
     * @param signType   签名类型
     * @return {String}
     */
    public static String bizPayUrl(String partnerKey, String appId, String mchId, String productId, String timeStamp, String nonceStr, SignType signType) {
        HashMap<String, String> map = new HashMap<>(5);
        map.put("appid", appId);
        map.put("mch_id", mchId);
        map.put("time_stamp", StrUtil.isEmpty(timeStamp) ? Long.toString(System.currentTimeMillis() / 1000) : timeStamp);
        map.put("nonce_str", StrUtil.isEmpty(nonceStr) ? IdUtil.fastSimpleUUID() : nonceStr);
        map.put("product_id", productId);
        return bizPayUrl(createSign(map, partnerKey, signType), appId, mchId, productId, timeStamp, nonceStr);
    }

    /**
     * <p>生成二维码链接</p>
     * <p>原生支付接口模式一(扫码模式一)</p>
     *
     * @param partnerKey 密钥
     * @param appId      公众账号ID
     * @param mchId      商户号
     * @param productId  商品ID
     * @return {String}
     */
    public static String bizPayUrl(String partnerKey, String appId, String mchId, String productId) {
        String timeStamp = Long.toString(System.currentTimeMillis() / 1000);
        String nonceStr = IdUtil.fastSimpleUUID();
        HashMap<String, String> map = new HashMap<>(5);
        map.put("appid", appId);
        map.put("mch_id", mchId);
        map.put("time_stamp", timeStamp);
        map.put("nonce_str", nonceStr);
        map.put("product_id", productId);
        return bizPayUrl(createSign(map, partnerKey, null), appId, mchId, productId, timeStamp, nonceStr);
    }


    /**
     * 替换url中的参数
     *
     * @param str   原始字符串
     * @param regex 表达式
     * @param args  替换字符串
     * @return {String}
     */
    public static String replace(String str, String regex, String... args) {
        for (String arg : args) {
            str = str.replaceFirst(regex, arg);
        }
        return str;
    }

    /**
     * 判断接口返回的 code
     *
     * @param codeValue code 值
     * @return 是否是 SUCCESS
     */
    public static boolean codeIsOk(String codeValue) {
        return StrUtil.isNotEmpty(codeValue) && "SUCCESS".equals(codeValue);
    }

    /**
     * <p>公众号支付-预付订单再次签名</p>
     * <p>注意此处签名方式需与统一下单的签名类型一致</p>
     *
     * @param prepayId   预付订单号
     * @param appId      应用编号
     * @param partnerKey API Key
     * @param signType   签名方式
     * @return 再次签名后的 Map
     */
    public static Map<String, String> prepayIdCreateSign(String prepayId, String appId, String partnerKey, SignType signType) {
        Map<String, String> packageParams = new HashMap<>(6);
        packageParams.put("appId", appId);
        packageParams.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
        packageParams.put("nonceStr", String.valueOf(System.currentTimeMillis()));
        packageParams.put("package", "prepay_id=" + prepayId);
        if (signType == null) {
            signType = SignType.MD5;
        }
        packageParams.put("signType", signType.getType());
        String packageSign = WxPayKit.createSign(packageParams, partnerKey, signType);
        packageParams.put("paySign", packageSign);
        return packageParams;
    }

    /**
     * JS 调起支付签名
     *
     * @param appId    应用编号
     * @param prepayId 预付订单号
     * @param keyPath  key.pem 证书路径
     * @return 唤起支付需要的参数
     * @throws Exception 错误信息
     */
    public static Map<String, String> jsApiCreateSign(String appId, String prepayId, String keyPath) throws Exception {
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        String nonceStr = String.valueOf(System.currentTimeMillis());
        String packageStr = "prepay_id=" + prepayId;
        Map<String, String> packageParams = new HashMap<>(6);
        packageParams.put("appId", appId);
        packageParams.put("timeStamp", timeStamp);
        packageParams.put("nonceStr", nonceStr);
        packageParams.put("package", packageStr);
        packageParams.put("signType", SignType.RSA.toString());
        ArrayList<String> list = new ArrayList<>();
        list.add(appId);
        list.add(timeStamp);
        list.add(nonceStr);
        list.add(packageStr);
        String packageSign = PayKit.createSign(
                PayKit.buildSignMessage(list),
                keyPath
        );
        packageParams.put("paySign", packageSign);
        return packageParams;
    }

    /**
     * <p>APP 支付-预付订单再次签名</p>
     * <p>注意此处签名方式需与统一下单的签名类型一致</p>
     *
     * @param appId      应用编号
     * @param partnerId  商户号
     * @param prepayId   预付订单号
     * @param partnerKey API Key
     * @param signType   签名方式
     * @return 再次签名后的 Map
     */
    public static Map<String, String> appPrepayIdCreateSign(String appId, String partnerId, String prepayId, String partnerKey, SignType signType) {
        Map<String, String> packageParams = new HashMap<>(8);
        packageParams.put("appid", appId);
        packageParams.put("partnerid", partnerId);
        packageParams.put("prepayid", prepayId);
        packageParams.put("package", "Sign=WXPay");
        packageParams.put("noncestr", String.valueOf(System.currentTimeMillis()));
        packageParams.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        if (signType == null) {
            signType = SignType.MD5;
        }
        String packageSign = createSign(packageParams, partnerKey, signType);
        // 部分微信APP支付 提示签名错误 解开下方注释 替换上边的代码就好。
        //        String packageSign = createAppSign(packageParams, partnerKey);
        packageParams.put("sign", packageSign);
        return packageParams;
    }

    /**
     * App 调起支付签名
     *
     * @param appId     应用编号
     * @param partnerId 商户编号
     * @param prepayId  预付订单号
     * @param keyPath   key.pem 证书路径
     * @return 唤起支付需要的参数
     * @throws Exception 错误信息
     */
    public static Map<String, String> appCreateSign(String appId, String partnerId, String prepayId, String keyPath) throws Exception {
        String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        String nonceStr = String.valueOf(System.currentTimeMillis());
        Map<String, String> packageParams = new HashMap<>(8);
        packageParams.put("appId", appId);
        packageParams.put("partnerid", partnerId);
        packageParams.put("prepayid", prepayId);
        packageParams.put("package", "Sign=WXPay");
        packageParams.put("timeStamp", timeStamp);
        packageParams.put("nonceStr", nonceStr);
        packageParams.put("signType", SignType.RSA.toString());
        ArrayList<String> list = new ArrayList<>();
        list.add(appId);
        list.add(timeStamp);
        list.add(nonceStr);
        list.add(prepayId);
        String packageSign = PayKit.createSign(
                PayKit.buildSignMessage(list),
                keyPath
        );
        packageParams.put("sign", packageSign);
        return packageParams;
    }

    /**
     * <p>小程序-预付订单再次签名</p>
     * <p>注意此处签名方式需与统一下单的签名类型一致</p>
     *
     * @param appId      应用编号
     * @param prepayId   预付订单号
     * @param partnerKey API Key
     * @param signType   签名方式
     * @return 再次签名后的 Map
     */
    public static Map<String, String> miniAppPrepayIdCreateSign(String appId, String prepayId, String partnerKey, SignType signType) {
        Map<String, String> packageParams = new HashMap<>(6);
        packageParams.put("appId", appId);
        packageParams.put("timeStamp", String.valueOf(System.currentTimeMillis() / 1000));
        packageParams.put("nonceStr", String.valueOf(System.currentTimeMillis()));
        packageParams.put("package", "prepay_id=" + prepayId);
        if (signType == null) {
            signType = SignType.MD5;
        }
        packageParams.put("signType", signType.getType());
        String packageSign = createSign(packageParams, partnerKey, signType);
        packageParams.put("paySign", packageSign);
        return packageParams;
    }

    /**
     * 构建 v3 接口所需的 Authorization
     *
     * @param method    {@link RequestMethodEnums} 请求方法
     * @param urlSuffix 可通过 WxApiType 来获取，URL挂载参数需要自行拼接
     * @param mchId     商户Id
     * @param serialNo  商户 API 证书序列号
     * @param key   key.pem 证书
     * @param body      接口请求参数
     * @param nonceStr  随机字符库
     * @param timestamp 时间戳
     * @param authType  认证类型
     * @return {@link String} 返回 v3 所需的 Authorization
     * @throws Exception 异常信息
     */
    public static String buildAuthorization(RequestMethodEnums method, String urlSuffix, String mchId,
                                            String serialNo, String key, String body, String nonceStr,
                                            long timestamp, String authType) throws Exception {
        //构建签名参数
        String buildSignMessage = PayKit.buildSignMessage(method, urlSuffix, timestamp, nonceStr, body);
        String signature = PayKit.createSign(buildSignMessage, key);
        //根据平台规则生成请求头 authorization
        return PayKit.getAuthorization(mchId, serialNo, nonceStr, String.valueOf(timestamp), signature, authType);
    }

    /**
     * 构建 v3 接口所需的 Authorization
     *
     * @param method     {@link RequestMethodEnums} 请求方法
     * @param urlSuffix  可通过 WxApiType 来获取，URL挂载参数需要自行拼接
     * @param mchId      商户Id
     * @param serialNo   商户 API 证书序列号
     * @param privateKey 商户私钥
     * @param body       接口请求参数
     * @param nonceStr   随机字符库
     * @param timestamp  时间戳
     * @param authType   认证类型
     * @return {@link String} 返回 v3 所需的 Authorization
     * @throws Exception 异常信息
     */
    public static String buildAuthorization(RequestMethodEnums method, String urlSuffix, String mchId,
                                            String serialNo, PrivateKey privateKey, String body, String nonceStr,
                                            long timestamp, String authType) throws Exception {
        //构建签名参数
        String buildSignMessage = PayKit.buildSignMessage(method, urlSuffix, timestamp, nonceStr, body);
        String signature = PayKit.createSign(buildSignMessage, privateKey);
        //根据平台规则生成请求头 authorization
        return PayKit.getAuthorization(mchId, serialNo, nonceStr, String.valueOf(timestamp), signature, authType);
    }

    /**
     * 构建 v3 接口所需的 Authorization
     *
     * @param method    {@link RequestMethodEnums} 请求方法
     * @param urlSuffix 可通过 WxApiType 来获取，URL挂载参数需要自行拼接
     * @param mchId     商户Id
     * @param serialNo  商户 API 证书序列号
     * @param keyPath   key.pem 证书路径
     * @param body      接口请求参数
     * @return {@link String} 返回 v3 所需的 Authorization
     * @throws Exception 异常信息
     */
    public static String buildAuthorization(RequestMethodEnums method, String urlSuffix, String mchId,
                                            String serialNo, String keyPath, String body) throws Exception {

        long timestamp = System.currentTimeMillis() / 1000;
        String authType = "WECHATPAY2-SHA256-RSA2048";
        String nonceStr = IdUtil.fastSimpleUUID();

        return buildAuthorization(method, urlSuffix, mchId, serialNo, keyPath, body, nonceStr, timestamp, authType);
    }

    /**
     * 构建 v3 接口所需的 Authorization
     *
     * @param method     {@link RequestMethodEnums} 请求方法
     * @param urlSuffix  可通过 WxApiType 来获取，URL挂载参数需要自行拼接
     * @param mchId      商户Id
     * @param serialNo   商户 API 证书序列号
     * @param privateKey key.pem 证书路径
     * @param body       接口请求参数
     * @return {@link String} 返回 v3 所需的 Authorization
     * @throws Exception 异常信息
     */
    public static String buildAuthorization(RequestMethodEnums method, String urlSuffix, String mchId,
                                            String serialNo, PrivateKey privateKey, String body) throws Exception {

        long timestamp = System.currentTimeMillis() / 1000;
        String authType = "WECHATPAY2-SHA256-RSA2048";
        String nonceStr = IdUtil.fastSimpleUUID();

        return buildAuthorization(method, urlSuffix, mchId, serialNo, privateKey, body, nonceStr, timestamp, authType);
    }

    /**
     * 验证签名
     *
     * @param response 接口请求返回的 {@link PaymentHttpResponse}
     * @param certPath 平台证书路径
     * @return 签名结果
     * @throws Exception 异常信息
     */
    public static boolean verifySignature(PaymentHttpResponse response, String certPath) throws Exception {
        String timestamp = response.getHeader("Wechatpay-Timestamp");
        String nonceStr = response.getHeader("Wechatpay-Nonce");
        String signature = response.getHeader("Wechatpay-Signature");
        String body = response.getBody();
        return verifySignature(signature, body, nonceStr, timestamp, FileUtil.getInputStream(certPath));
    }

    /**
     * 验证签名
     *
     * @param response 接口请求返回的 {@link PaymentHttpResponse}
     * @param cert     平台证书
     * @return 签名结果
     * @throws Exception 异常信息
     */
    public static boolean verifySignature(PaymentHttpResponse response, X509Certificate cert) throws Exception {
        String timestamp = response.getHeader("Wechatpay-Timestamp");
        String nonceStr = response.getHeader("Wechatpay-Nonce");
        String signature = response.getHeader("Wechatpay-Signature");
        String body = response.getBody();
        return verifySignature(signature, body, nonceStr, timestamp, cert);
    }

    /**
     * 验证签名
     *
     * @param signature 待验证的签名
     * @param body      应答主体
     * @param nonce     随机串
     * @param timestamp 时间戳
     * @param publicKey 微信支付平台公钥
     * @return 签名结果
     * @throws Exception 异常信息
     */
    public static boolean verifySignature(String signature, String body, String nonce, String timestamp, String publicKey) throws Exception {
        String buildSignMessage = PayKit.buildSignMessage(timestamp, nonce, body);
        return RsaKit.checkByPublicKey(buildSignMessage, signature, publicKey);
    }

    /**
     * 验证签名
     *
     * @param signature 待验证的签名
     * @param body      应答主体
     * @param nonce     随机串
     * @param timestamp 时间戳
     * @param publicKey {@link PublicKey} 微信支付平台公钥
     * @return 签名结果
     * @throws Exception 异常信息
     */
    public static boolean verifySignature(String signature, String body, String nonce, String timestamp, PublicKey publicKey) throws Exception {
        String buildSignMessage = PayKit.buildSignMessage(timestamp, nonce, body);
        return RsaKit.checkByPublicKey(buildSignMessage, signature, publicKey);
    }

    /**
     * 验证签名
     *
     * @param signature       待验证的签名
     * @param body            应答主体
     * @param nonce           随机串
     * @param timestamp       时间戳
     * @param certInputStream 微信支付平台证书输入流
     * @return 签名结果
     * @throws Exception 异常信息
     */
    public static boolean verifySignature(String signature, String body, String nonce, String timestamp, InputStream certInputStream) throws Exception {
        String buildSignMessage = PayKit.buildSignMessage(timestamp, nonce, body);
        //获取证书
        X509Certificate certificate = PayKit.getCertificate(certInputStream);
        PublicKey publicKey = certificate.getPublicKey();
        return RsaKit.checkByPublicKey(buildSignMessage, signature, publicKey);
    }

    /**
     * 验证签名
     *
     * @param signature   待验证的签名
     * @param body        应答主体
     * @param nonce       随机串
     * @param timestamp   时间戳
     * @param certificate 微信支付平台证书
     * @return 签名结果
     * @throws Exception 异常信息
     */
    public static boolean verifySignature(String signature, String body, String nonce, String timestamp, X509Certificate certificate) throws Exception {
        String buildSignMessage = PayKit.buildSignMessage(timestamp, nonce, body);
        PublicKey publicKey = certificate.getPublicKey();
        return RsaKit.checkByPublicKey(buildSignMessage, signature, publicKey);
    }

    /**
     * v3 支付异步通知验证签名
     *
     * @param serialNo  证书序列号
     * @param body      异步通知密文
     * @param signature 签名
     * @param nonce     随机字符串
     * @param timestamp 时间戳
     * @param key       api 密钥
     * @param certPath  平台证书路径
     * @return 异步通知明文
     * @throws Exception 异常信息
     */
    public static String verifyNotify(String serialNo, String body, String signature, String nonce,
                                      String timestamp, String key, String certPath) throws Exception {
        BufferedInputStream inputStream = FileUtil.getInputStream(certPath);
        //获取平台证书序列号
        X509Certificate certificate = PayKit.getCertificate(inputStream);
        String serialNumber = certificate.getSerialNumber().toString(16).toUpperCase();
        System.out.println(serialNumber);
        //验证证书序列号
        if (serialNumber.equals(serialNo)) {
            boolean verifySignature = WxPayKit.verifySignature(signature, body, nonce, timestamp, certificate.getPublicKey());
            if (verifySignature) {
                JSONObject resultObject = JSONUtil.parseObj(body);
                JSONObject resource = resultObject.getJSONObject("resource");
                String cipherText = resource.getStr("ciphertext");
                String nonceStr = resource.getStr("nonce");
                String associatedData = resource.getStr("associated_data");

                AesUtil aesUtil = new AesUtil(key.getBytes(StandardCharsets.UTF_8));
                //密文解密
                return aesUtil.decryptToString(
                        associatedData.getBytes(StandardCharsets.UTF_8),
                        nonceStr.getBytes(StandardCharsets.UTF_8),
                        cipherText
                );
            }
        }
        return null;
    }

    /**
     * v3 支付异步通知验证签名
     *
     * @param serialNo  证书序列号
     * @param body      异步通知密文
     * @param signature 签名
     * @param nonce     随机字符串
     * @param timestamp 时间戳
     * @param key       api 密钥
     * @return 异步通知明文
     * @throws Exception 异常信息
     */
    public static String verifyNotify(String serialNo, String body, String signature, String nonce,
                                      String timestamp, String key, X509Certificate certificate) throws Exception {
        String serialNumber = certificate.getSerialNumber().toString(16).toUpperCase();
        //验证证书序列号
        if (serialNumber.equals(serialNo)) {
            boolean verifySignature = WxPayKit.verifySignature(signature, body, nonce, timestamp, certificate.getPublicKey());
            if (verifySignature) {
                JSONObject resultObject = JSONUtil.parseObj(body);
                JSONObject resource = resultObject.getJSONObject("resource");
                String cipherText = resource.getStr("ciphertext");
                String nonceStr = resource.getStr("nonce");
                String associatedData = resource.getStr("associated_data");

                AesUtil aesUtil = new AesUtil(key.getBytes(StandardCharsets.UTF_8));
                //密文解密
                return aesUtil.decryptToString(
                        associatedData.getBytes(StandardCharsets.UTF_8),
                        nonceStr.getBytes(StandardCharsets.UTF_8),
                        cipherText
                );
            }
        }
        return null;
    }
}
