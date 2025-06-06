package org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat;

import cn.hutool.core.net.URLDecoder;
import cn.hutool.core.net.URLEncoder;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.convention.result.ResultMessage;
import org.duku.mall.framework.starter.distributedid.toolkit.SnowflakeIdUtil;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.utils.CurrencyUtil;
import org.duku.mall.framework.starter.common.common.utils.ResultUtil;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;
import org.duku.mall.framework.starter.common.modules.connect.entity.Connect;
import org.duku.mall.framework.starter.common.modules.connect.entity.enums.SourceEnum;
import org.duku.mall.framework.starter.common.modules.connect.service.ConnectService;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.ConnectQueryDTO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderService;
import org.duku.mall.framework.starter.common.modules.payment.entity.dos.RefundLog;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.PaymentMethodEnum;
import org.duku.mall.framework.starter.common.modules.payment.kit.CashierSupport;
import org.duku.mall.framework.starter.common.modules.payment.kit.Payment;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.PaymentHttpResponse;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.enums.RequestMethodEnums;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.enums.SignType;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.kit.*;
import org.duku.mall.framework.starter.common.modules.payment.kit.core.utils.DateTimeZoneUtil;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PayParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.dto.PaymentSuccessParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.params.dto.CashierParam;
import org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model.RefundModel;
import org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model.UnifiedOrderModel;
import org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.enums.WechatApiEnum;
import org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.enums.WechatDomain;
import org.duku.mall.framework.starter.common.modules.payment.kit.plugin.wechat.model.*;
import org.duku.mall.framework.starter.common.modules.payment.service.PaymentService;
import org.duku.mall.framework.starter.common.modules.payment.service.RefundLogService;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Setting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.connect.WechatConnectSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.connect.dto.WechatConnectSettingItem;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.WechatPaymentSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.WithdrawalSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.enums.SettingEnum;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dos.MemberWithdrawApply;
import org.duku.mall.framework.starter.common.modules.wallet.entity.dto.TransferResultDTO;
import org.duku.mall.framework.starter.user.core.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class WechatPlugin implements Payment {


    /**
     * 收银台
     */
    @Autowired
    private CashierSupport cashierSupport;
    /**
     * 支付日志
     */
    @Autowired
    private PaymentService paymentService;
    /**
     * 缓存
     */
    @Autowired
    private SingletonCache<String> cache;
    /**
     * 退款日志
     */
    @Autowired
    private RefundLogService refundLogService;
    /**
     * 配置
     */
    @Autowired
    private SettingService settingService;
    /**
     * 联合登陆
     */
    @Autowired
    private ConnectService connectService;
    /**
     * 联合登陆
     */
    @Autowired
    private OrderService orderService;


    @Override
    public ResultMessage<Object> h5pay(HttpServletRequest request, HttpServletResponse response1, PayParam payParam) {

        try {
            CashierParam cashierParam = cashierSupport.cashierParam(payParam);

            //支付参数准备
            SceneInfo sceneInfo = new SceneInfo();
            sceneInfo.setPayer_client_ip(IpKit.getRealIp(request));
            H5Info h5Info = new H5Info();
            h5Info.setType("WAP");
            sceneInfo.setH5_info(h5Info);

            //支付金额
            Integer fen = CurrencyUtil.fen(cashierParam.getPrice());
            //第三方付款订单
            String outOrderNo = SnowflakeIdUtil.nextIdStr();
            //过期时间
            String timeExpire = DateTimeZoneUtil.dateToTimeZone(System.currentTimeMillis() + 1000 * 60 * 3);

            //回传数据
            String attach = URLEncoder.createDefault().encode(JSONUtil.toJsonStr(payParam), StandardCharsets.UTF_8);


            WechatPaymentSetting setting = wechatPaymentSetting();
            String appid = setting.getH5AppId();
            if (appid == null) {
                throw new ServiceException(ResultCode.WECHAT_PAYMENT_NOT_SETTING);
            }
            UnifiedOrderModel unifiedOrderModel = new UnifiedOrderModel()
                    .setAppid(appid)
                    .setMchid(setting.getMchId())
                    .setDescription(cashierParam.getDetail())
                    .setOut_trade_no(outOrderNo)
                    .setTime_expire(timeExpire)
                    .setAttach(attach)
                    .setNotify_url(notifyUrl(wechatPaymentSetting().getCallbackUrl(), PaymentMethodEnum.WECHAT))
                    .setAmount(new Amount().setTotal(fen)).setScene_info(sceneInfo);

            log.info("统一下单参数 {}", JSONUtil.toJsonStr(unifiedOrderModel));
            PaymentHttpResponse response = WechatApi.v3(
                    RequestMethodEnums.POST,
                    WechatDomain.CHINA.toString(),
                    WechatApiEnum.H5_PAY.toString(),
                    setting.getMchId(),
                    setting.getSerialNumber(),
                    null,
                    setting.getApiclient_key(),
                    JSONUtil.toJsonStr(unifiedOrderModel)
            );

            updateOrderPayNo(payParam,outOrderNo);

            return ResultUtil.data(JSONUtil.toJsonStr(response.getBody()));
        } catch (Exception e) {
            log.error("微信H5支付错误", e);
            throw new ServiceException(ResultCode.PAY_ERROR);
        }
    }


    @Override
    public ResultMessage<Object> jsApiPay(HttpServletRequest request, PayParam payParam) {

        try {
            Connect connect = connectService.queryConnect(
                    ConnectQueryDTO.builder().userId(UserContext.getCurrentUser().getUserId()).unionType(SourceEnum.WECHAT_OFFIACCOUNT_OPEN_ID.name()).build()
            );
            if (connect == null) {
                return null;
            }

            Payer payer = new Payer();
            payer.setOpenid(connect.getUnionId());

            CashierParam cashierParam = cashierSupport.cashierParam(payParam);

            //支付金额
            Integer fen = CurrencyUtil.fen(cashierParam.getPrice());
            //第三方付款订单
            String outOrderNo = SnowflakeIdUtil.nextIdStr();
            //过期时间
            String timeExpire = DateTimeZoneUtil.dateToTimeZone(System.currentTimeMillis() + 1000 * 60 * 3);

            String attach = URLEncoder.createDefault().encode(JSONUtil.toJsonStr(payParam), StandardCharsets.UTF_8);

            WechatPaymentSetting setting = wechatPaymentSetting();
            String appid = setting.getJsapiAppId();
            if (appid == null) {
                throw new ServiceException(ResultCode.WECHAT_PAYMENT_NOT_SETTING);
            }
            UnifiedOrderModel unifiedOrderModel = new UnifiedOrderModel()
                    .setAppid(appid)
                    .setMchid(setting.getMchId())
                    .setDescription(cashierParam.getDetail())
                    .setOut_trade_no(outOrderNo)
                    .setTime_expire(timeExpire)
                    .setAttach(attach)
                    .setNotify_url(notifyUrl(wechatPaymentSetting().getCallbackUrl(), PaymentMethodEnum.WECHAT))
                    .setAmount(new Amount().setTotal(fen))
                    .setPayer(payer);

            log.info("统一下单参数 {}", JSONUtil.toJsonStr(unifiedOrderModel));
            PaymentHttpResponse response = WechatApi.v3(
                    RequestMethodEnums.POST,
                    WechatDomain.CHINA.toString(),
                    WechatApiEnum.JS_API_PAY.toString(),
                    setting.getMchId(),
                    setting.getSerialNumber(),
                    null,
                    setting.getApiclient_key(),
                    JSONUtil.toJsonStr(unifiedOrderModel)
            );
            //根据证书序列号查询对应的证书来验证签名结果
            boolean verifySignature = WxPayKit.verifySignature(response, getPlatformCert());
            log.info("verifySignature: {}", verifySignature);
            log.info("统一下单响应 {}", response);

            if (verifySignature) {
                String body = response.getBody();
                JSONObject jsonObject = JSONUtil.parseObj(body);
                String prepayId = jsonObject.getStr("prepay_id");
                Map<String, String> map = WxPayKit.jsApiCreateSign(appid, prepayId, setting.getApiclient_key());
                log.info("唤起支付参数:{}", map);

                updateOrderPayNo(payParam,outOrderNo);

                return ResultUtil.data(map);
            }
            log.error("微信支付参数验证错误，请及时处理");
            throw new ServiceException(ResultCode.PAY_ERROR);
        } catch (Exception e) {
            log.error("支付异常", e);
            throw new ServiceException(ResultCode.PAY_ERROR);
        }
    }


    @Override
    public ResultMessage<Object> appPay(HttpServletRequest request, PayParam payParam) {

        try {

            CashierParam cashierParam = cashierSupport.cashierParam(payParam);

            //支付金额
            Integer fen = CurrencyUtil.fen(cashierParam.getPrice());
            //第三方付款订单
            String outOrderNo = SnowflakeIdUtil.nextIdStr();
            //过期时间
            String timeExpire = DateTimeZoneUtil.dateToTimeZone(System.currentTimeMillis() + 1000 * 60 * 3);

            String attach = URLEncoder.createDefault().encode(JSONUtil.toJsonStr(payParam), StandardCharsets.UTF_8);

            WechatPaymentSetting setting = wechatPaymentSetting();
            String appid = setting.getJsapiAppId();
            if (appid == null) {
                throw new ServiceException(ResultCode.WECHAT_PAYMENT_NOT_SETTING);
            }
            UnifiedOrderModel unifiedOrderModel = new UnifiedOrderModel()
                    .setAppid(appid)
                    .setMchid(setting.getMchId())
                    .setDescription(cashierParam.getDetail())
                    .setOut_trade_no(outOrderNo)
                    .setTime_expire(timeExpire)
                    .setAttach(attach)
                    .setNotify_url(notifyUrl(wechatPaymentSetting().getCallbackUrl(), PaymentMethodEnum.WECHAT))
                    .setAmount(new Amount().setTotal(fen));


            log.info("统一下单参数 {}", JSONUtil.toJsonStr(unifiedOrderModel));
            PaymentHttpResponse response = WechatApi.v3(
                    RequestMethodEnums.POST,
                    WechatDomain.CHINA.toString(),
                    WechatApiEnum.APP_PAY.toString(),
                    setting.getMchId(),
                    setting.getSerialNumber(),
                    null,
                    setting.getApiclient_key(),
                    JSONUtil.toJsonStr(unifiedOrderModel)
            );
            //根据证书序列号查询对应的证书来验证签名结果
            boolean verifySignature = WxPayKit.verifySignature(response, getPlatformCert());
            log.info("verifySignature: {}", verifySignature);
            log.info("统一下单响应 {}", response);

            if (verifySignature) {
                JSONObject jsonObject = JSONUtil.parseObj(response.getBody());
                String prepayId = jsonObject.getStr("prepay_id");
                Map<String, String> map = WxPayKit.appPrepayIdCreateSign(appid,
                        setting.getMchId(),
                        prepayId,
                        setting.getApiclient_key(), SignType.MD5);
                log.info("唤起支付参数:{}", map);

                updateOrderPayNo(payParam,outOrderNo);

                return ResultUtil.data(map);
            }
            log.error("微信支付参数验证错误，请及时处理");
            throw new ServiceException(ResultCode.PAY_ERROR);
        } catch (Exception e) {
            log.error("支付异常", e);
            throw new ServiceException(ResultCode.PAY_ERROR);
        }
    }


    @Override
    public ResultMessage<Object> nativePay(HttpServletRequest request, PayParam payParam) {

        try {

            CashierParam cashierParam = cashierSupport.cashierParam(payParam);

            //支付金额
            Integer fen = CurrencyUtil.fen(cashierParam.getPrice());
            //第三方付款订单
            String outOrderNo = SnowflakeIdUtil.nextIdStr();
            //过期时间
            String timeExpire = DateTimeZoneUtil.dateToTimeZone(System.currentTimeMillis() + 1000 * 60 * 3);

            String attach = URLEncoder.createDefault().encode(JSONUtil.toJsonStr(payParam), StandardCharsets.UTF_8);

            WechatPaymentSetting setting = wechatPaymentSetting();

            String appid = setting.getNativeAppId();
            if (appid == null) {
                throw new ServiceException(ResultCode.WECHAT_PAYMENT_NOT_SETTING);
            }
            UnifiedOrderModel unifiedOrderModel = new UnifiedOrderModel()
                    .setAppid(appid)
                    .setMchid(setting.getMchId())
                    .setDescription(cashierParam.getDetail())
                    .setOut_trade_no(outOrderNo)
                    .setTime_expire(timeExpire)
                    //回传参数
                    .setAttach(attach)
                    .setNotify_url(notifyUrl(wechatPaymentSetting().getCallbackUrl(), PaymentMethodEnum.WECHAT))
                    .setAmount(new Amount().setTotal(fen));

            log.info("统一下单参数 {}", JSONUtil.toJsonStr(unifiedOrderModel));
            PaymentHttpResponse response = WechatApi.v3(
                    RequestMethodEnums.POST,
                    WechatDomain.CHINA.toString(),
                    WechatApiEnum.NATIVE_PAY.toString(),
                    setting.getMchId(),
                    setting.getSerialNumber(),
                    null,
                    setting.getApiclient_key(),
                    JSONUtil.toJsonStr(unifiedOrderModel)
            );
            log.info("统一下单响应 {}", response);
            //根据证书序列号查询对应的证书来验证签名结果
            boolean verifySignature = WxPayKit.verifySignature(response, getPlatformCert());
            log.info("verifySignature: {}", verifySignature);

            if (verifySignature) {
                updateOrderPayNo(payParam,outOrderNo);

                return ResultUtil.data(new JSONObject(response.getBody()).getStr("code_url"));
            } else {
                log.error("微信支付参数验证错误，请及时处理");
                throw new ServiceException(ResultCode.PAY_ERROR);
            }
        } catch (ServiceException e) {
            log.error("支付异常", e);
            throw new ServiceException(ResultCode.PAY_ERROR);
        } catch (Exception e) {
            log.error("支付异常", e);
            throw new ServiceException(ResultCode.PAY_ERROR);
        }
    }

    @Override
    public ResultMessage<Object> mpPay(HttpServletRequest request, PayParam payParam) {

        try {
            Connect connect = connectService.queryConnect(
                    ConnectQueryDTO.builder().userId(UserContext.getCurrentUser().getUserId()).unionType(SourceEnum.WECHAT_MP_OPEN_ID.name()).build()
            );
            if (connect == null) {
                return null;
            }

            Payer payer = new Payer();
            payer.setOpenid(connect.getUnionId());

            CashierParam cashierParam = cashierSupport.cashierParam(payParam);

            //支付金额
            Integer fen = CurrencyUtil.fen(cashierParam.getPrice());
            //第三方付款订单
            String outOrderNo = SnowflakeIdUtil.nextIdStr();
            //过期时间
            String timeExpire = DateTimeZoneUtil.dateToTimeZone(System.currentTimeMillis() + 1000 * 60 * 3);

            //微信小程序，appid 需要单独获取，这里读取了联合登陆配置的appid ，实际场景小程序自动登录，所以这个appid是最为保险的做法
            //如果有2开需求，这里需要调整，修改这个appid的获取途径即可
            String appid = wechatPaymentSetting().getMpAppId();
            if (StringUtils.isEmpty(appid)) {
                throw new ServiceException(ResultCode.WECHAT_PAYMENT_NOT_SETTING);
            }
            String attach = URLEncoder.createDefault().encode(JSONUtil.toJsonStr(payParam), StandardCharsets.UTF_8);

            WechatPaymentSetting setting = wechatPaymentSetting();
            UnifiedOrderModel unifiedOrderModel = new UnifiedOrderModel()
                    .setAppid(appid)
                    .setMchid(setting.getMchId())
                    .setDescription(cashierParam.getDetail())
                    .setOut_trade_no(outOrderNo)
                    .setTime_expire(timeExpire)
                    .setAttach(attach)
                    .setNotify_url(notifyUrl(wechatPaymentSetting().getCallbackUrl(), PaymentMethodEnum.WECHAT))
                    .setAmount(new Amount().setTotal(fen))
                    .setPayer(payer);

            log.info("统一下单参数 {}", JSONUtil.toJsonStr(unifiedOrderModel));
            PaymentHttpResponse response = WechatApi.v3(
                    RequestMethodEnums.POST,
                    WechatDomain.CHINA.toString(),
                    WechatApiEnum.JS_API_PAY.toString(),
                    setting.getMchId(),
                    setting.getSerialNumber(),
                    null,
                    setting.getApiclient_key(),
                    JSONUtil.toJsonStr(unifiedOrderModel)
            );
            //根据证书序列号查询对应的证书来验证签名结果
            boolean verifySignature = WxPayKit.verifySignature(response, getPlatformCert());
            log.info("verifySignature: {}", verifySignature);
            log.info("统一下单响应 {}", response);

            if (verifySignature) {
                String body = response.getBody();
                JSONObject jsonObject = JSONUtil.parseObj(body);
                String prepayId = jsonObject.getStr("prepay_id");
                Map<String, String> map = WxPayKit.jsApiCreateSign(appid, prepayId, setting.getApiclient_key());
                log.info("唤起支付参数:{}", map);
                updateOrderPayNo(payParam,outOrderNo);
                return ResultUtil.data(map);
            }
            log.error("微信支付参数验证错误，请及时处理");
            throw new ServiceException(ResultCode.PAY_ERROR);
        } catch (Exception e) {
            log.error("支付异常", e);
            throw new ServiceException(ResultCode.PAY_ERROR);
        }

    }

    @Override
    public void callBack(HttpServletRequest request) {
        try {
            verifyNotify(request);
        } catch (Exception e) {
            log.error("支付异常", e);
        }
    }

    @Override
    public void notify(HttpServletRequest request) {
        try {
            verifyNotify(request);
        } catch (Exception e) {
            log.error("支付异常", e);
        }
    }

    /**
     * 微信提现
     * 文档地址：https://pay.weixin.qq.com/docs/merchant/apis/batch-transfer-to-balance/transfer-batch/initiate-batch-transfer.html
     *
     * @param memberWithdrawApply 会员提现申请
     */
    @Override
    public TransferResultDTO transfer(MemberWithdrawApply memberWithdrawApply) {
        try {
            //获取提现设置
            WithdrawalSetting withdrawalSetting = new Gson().fromJson(settingService.get(SettingEnum.WITHDRAWAL_SETTING.name()).getSettingValue(),
                    WithdrawalSetting.class);

            //获取用户OPENID
            WechatConnectSetting wechatConnectSetting = new Gson().fromJson(settingService.get(SettingEnum.WECHAT_CONNECT.name()).getSettingValue()
                    , WechatConnectSetting.class);
            String source = "";
            for (WechatConnectSettingItem wechatConnectSettingItem : wechatConnectSetting.getWechatConnectSettingItems()) {
                if (wechatConnectSettingItem.getAppId().equals(withdrawalSetting.getWechatAppId())) {
                    switch (wechatConnectSettingItem.getClientType()) {
                        case "PC":
                            source = SourceEnum.WECHAT_PC_OPEN_ID.name();
                            break;
                        case "H5":
                            source = SourceEnum.WECHAT_OFFIACCOUNT_OPEN_ID.name();
                            break;
                        case "MP":
                            source = SourceEnum.WECHAT_MP_OPEN_ID.name();
                            break;
                        case "APP":
                            source = SourceEnum.WECHAT_APP_OPEN_ID.name();
                            break;
                    }
                }
            }

            //获取微信设置
            WechatPaymentSetting wechatPaymentSetting = wechatPaymentSetting();
            //获取用户openId
            Connect connect = connectService.queryConnect(
                    ConnectQueryDTO.builder().userId(memberWithdrawApply.getMemberId())
                            .unionType(source).build()
            );
            //构建提现，发起申请
            TransferModel transferModel = new TransferModel()
                    .setAppid(withdrawalSetting.getWechatAppId())
                    .setOut_batch_no(SnowflakeIdUtil.createStr("T"))
                    .setBatch_name("用户提现")
                    .setBatch_remark("用户提现")
                    .setTotal_amount(CurrencyUtil.fen(memberWithdrawApply.getApplyMoney()))
                    .setTotal_num(1)
                    .setTransfer_scene_id("1000");
            List<TransferDetailInput> transferDetailListList = new ArrayList<>();
            {
                TransferDetailInput transferDetailInput = new TransferDetailInput();
                transferDetailInput.setOut_detail_no(SnowflakeIdUtil.createStr("TD"));
                transferDetailInput.setTransfer_amount(CurrencyUtil.fen(memberWithdrawApply.getApplyMoney()));
                transferDetailInput.setTransfer_remark("用户提现");
                transferDetailInput.setOpenid(connect.getUnionId());
                transferDetailListList.add(transferDetailInput);
            }
            transferModel.setTransfer_detail_list(transferDetailListList);

            PaymentHttpResponse response = WechatApi.v3(
                    RequestMethodEnums.POST,
                    WechatDomain.CHINA.toString(),
                    WechatApiEnum.TRANSFER_BATCHES.toString(),
                    wechatPaymentSetting.getMchId(),
                    wechatPaymentSetting.getSerialNumber(),
                    null,
                    wechatPaymentSetting.getApiclient_key(),
                    JSONUtil.toJsonStr(transferModel)
            );
            log.info("微信提现响应 {}", response);
            String body = response.getBody();
            JSONObject jsonObject = JSONUtil.parseObj(body);

            return TransferResultDTO.builder().result(jsonObject.getStr("batch_id") != null).response(body).build();
            //根据自身业务进行接下来的任务处理
        } catch (Exception e) {
            e.printStackTrace();
            return TransferResultDTO.builder().result(false).response(e.getMessage()).build();
        }

    }

    /**
     * 验证结果，执行支付回调
     *
     * @param request
     * @throws Exception
     */
    private void verifyNotify(HttpServletRequest request) throws Exception {

        String timestamp = request.getHeader("Wechatpay-Timestamp");
        String nonce = request.getHeader("Wechatpay-Nonce");
        String serialNo = request.getHeader("Wechatpay-Serial");
        String signature = request.getHeader("Wechatpay-Signature");

        log.info("timestamp:{} nonce:{} serialNo:{} signature:{}", timestamp, nonce, serialNo, signature);
        String result = HttpKit.readData(request);
        log.info("微信支付通知密文 {}", result);

        WechatPaymentSetting setting = wechatPaymentSetting();
        //校验服务器端响应¬
        String plainText = WxPayKit.verifyNotify(serialNo, result, signature, nonce, timestamp,
                setting.getApiKey3(), Objects.requireNonNull(getPlatformCert()));

        log.info("微信支付通知明文 {}", plainText);

        JSONObject jsonObject = JSONUtil.parseObj(plainText);

        String payParamStr = jsonObject.getStr("attach");
        String payParamJson = URLDecoder.decode(payParamStr, StandardCharsets.UTF_8);
        PayParam payParam = JSONUtil.toBean(payParamJson, PayParam.class);


        String tradeNo = jsonObject.getStr("transaction_id");
        Double totalAmount = CurrencyUtil.reversalFen(jsonObject.getJSONObject("amount").getDouble("total"));

        PaymentSuccessParam paymentSuccessParams = new PaymentSuccessParam(
                PaymentMethodEnum.WECHAT.name(),
                tradeNo,
                totalAmount,
                payParam
        );

        paymentService.success(paymentSuccessParams);
        log.info("微信支付回调：支付成功{}", plainText);
    }

    @Override
    public void refund(RefundLog refundLog) {

        try {

            Amount amount = new Amount().setRefund(CurrencyUtil.fen(refundLog.getTotalAmount()))
                    .setTotal(CurrencyUtil.fen(orderService.getPaymentTotal(refundLog.getOrderSn())));

            //退款参数准备
            RefundModel refundModel = new RefundModel()
                    .setTransaction_id(refundLog.getPaymentReceivableNo())
                    .setOut_refund_no(refundLog.getOutOrderNo())
                    .setReason(refundLog.getRefundReason())
                    .setAmount(amount)
                    .setNotify_url(refundNotifyUrl(wechatPaymentSetting().getCallbackUrl(), PaymentMethodEnum.WECHAT));

            WechatPaymentSetting setting = wechatPaymentSetting();

            log.info("微信退款参数 {}", JSONUtil.toJsonStr(refundModel));
            PaymentHttpResponse response = WechatApi.v3(
                    RequestMethodEnums.POST,
                    WechatDomain.CHINA.toString(),
                    WechatApiEnum.DOMESTIC_REFUNDS.toString(),
                    setting.getMchId(),
                    setting.getSerialNumber(),
                    null,
                    setting.getApiclient_key(),
                    JSONUtil.toJsonStr(refundModel)
            );
            log.info("微信退款响应 {}", response);
            //退款申请成功
            if (response.getStatus() == 200) {
                refundLogService.save(refundLog);
            } else {
                //退款申请失败
                refundLog.setErrorMessage(response.getBody());
                refundLogService.save(refundLog);
            }
        } catch (Exception e) {
            log.error("微信退款申请失败", e);
        }

    }

    @Override
    public void refundNotify(HttpServletRequest request) {
        String timestamp = request.getHeader("Wechatpay-Timestamp");
        String nonce = request.getHeader("Wechatpay-Nonce");
        String serialNo = request.getHeader("Wechatpay-Serial");
        String signature = request.getHeader("Wechatpay-Signature");

        log.info("timestamp:{} nonce:{} serialNo:{} signature:{}", timestamp, nonce, serialNo, signature);
        String result = HttpKit.readData(request);
        log.info("微信退款通知密文 {}", result);
        JSONObject ciphertext = JSONUtil.parseObj(result);

        try { //校验服务器端响应¬
            String plainText = WxPayKit.verifyNotify(serialNo, result, signature, nonce, timestamp,
                    wechatPaymentSetting().getApiKey3(), Objects.requireNonNull(getPlatformCert()));
            log.info("微信退款通知明文 {}", plainText);

            if (("REFUND.SUCCESS").equals(ciphertext.getStr("event_type"))) {
                log.info("退款成功 {}", plainText);
                //校验服务器端响应
                JSONObject jsonObject = JSONUtil.parseObj(plainText);
                String transactionId = jsonObject.getStr("transaction_id");
                String refundId = jsonObject.getStr("refund_id");

                RefundLog refundLog = refundLogService.getOne(new LambdaQueryWrapper<RefundLog>().eq(RefundLog::getPaymentReceivableNo,
                        transactionId));
                if (refundLog != null) {
                    refundLog.setIsRefund(true);
                    refundLog.setReceivableNo(refundId);
                    refundLogService.saveOrUpdate(refundLog);
                }

            } else {
                log.info("退款失败 {}", plainText);
                JSONObject jsonObject = JSONUtil.parseObj(plainText);
                String transactionId = jsonObject.getStr("transaction_id");
                String refundId = jsonObject.getStr("refund_id");

                RefundLog refundLog = refundLogService.getOne(new LambdaQueryWrapper<RefundLog>().eq(RefundLog::getPaymentReceivableNo,
                        transactionId));
                if (refundLog != null) {
                    refundLog.setReceivableNo(refundId);
                    refundLog.setErrorMessage(ciphertext.getStr("summary"));
                    refundLogService.saveOrUpdate(refundLog);
                }
            }
        } catch (Exception e) {
            log.error("微信退款失败", e);
        }
    }

    /**
     * 获取微信支付配置
     *
     * @return
     */
    private WechatPaymentSetting wechatPaymentSetting() {
        try {
            Setting systemSetting = settingService.get(SettingEnum.WECHAT_PAYMENT.name());
            WechatPaymentSetting wechatPaymentSetting = JSONUtil.toBean(systemSetting.getSettingValue(), WechatPaymentSetting.class);
            return wechatPaymentSetting;
        } catch (Exception e) {
            log.error("微信支付暂不支持", e);
            throw new ServiceException(ResultCode.PAY_NOT_SUPPORT);
        }
    }

    /**
     * 获取平台公钥
     *
     * @return 平台公钥
     */
    private X509Certificate getPlatformCert() {
        //获取缓存中的平台公钥，如果有则直接返回，否则去微信请求
        String publicCert = cache.getString(CachePrefix.WECHAT_PLAT_FORM_CERT.getPrefix());
        if (!StringUtils.isEmpty(publicCert)) {
            return PayKit.getCertificate(publicCert);
        }
        //获取平台证书列表
        try {

            WechatPaymentSetting setting = wechatPaymentSetting();

            PaymentHttpResponse response = WechatApi.v3(
                    RequestMethodEnums.GET,
                    WechatDomain.CHINA.toString(),
                    WechatApiEnum.GET_CERTIFICATES.toString(),
                    setting.getMchId(),
                    setting.getSerialNumber(),
                    null,
                    setting.getApiclient_key(),
                    ""
            );
            String body = response.getBody();
            log.info("获取微信平台证书body: {}", body);
            if (response.getStatus() == 200) {
                JSONObject jsonObject = JSONUtil.parseObj(body);
                JSONArray dataArray = jsonObject.getJSONArray("data");
                //默认认为只有一个平台证书
                JSONObject encryptObject = dataArray.getJSONObject(0);
                JSONObject encryptCertificate = encryptObject.getJSONObject("encrypt_certificate");
                String associatedData = encryptCertificate.getStr("associated_data");
                String cipherText = encryptCertificate.getStr("ciphertext");
                String nonce = encryptCertificate.getStr("nonce");
                publicCert = getPlatformCertStr(associatedData, nonce, cipherText);
                long second = (PayKit.getCertificate(publicCert).getNotAfter().getTime() - System.currentTimeMillis()) / 1000;
                cache.put(CachePrefix.WECHAT_PLAT_FORM_CERT.getPrefix(), publicCert, second);
            } else {
                log.error("证书获取失败：{}" + body);
                throw new ServiceException(ResultCode.WECHAT_CERT_ERROR);
            }
            return PayKit.getCertificate(publicCert);
        } catch (Exception e) {
            log.error("证书获取失败", e);
        }
        return null;
    }

    /**
     * 获取平台证书缓存的字符串
     * 下列各个密钥参数
     *
     * @param associatedData 密钥参数
     * @param nonce          密钥参数
     * @param cipherText     密钥参数
     * @return platform key
     * @throws GeneralSecurityException 密钥获取异常
     */
    private String getPlatformCertStr(String associatedData, String nonce, String cipherText) throws GeneralSecurityException {


        AesUtil aesUtil = new AesUtil(wechatPaymentSetting().getApiKey3().getBytes(StandardCharsets.UTF_8));
        //平台证书密文解密
        //encrypt_certificate 中的  associated_data nonce  ciphertext
        return aesUtil.decryptToString(
                associatedData.getBytes(StandardCharsets.UTF_8),
                nonce.getBytes(StandardCharsets.UTF_8),
                cipherText
        );
    }

    /**
     * 修改订单支付单号
     * @param payParam 支付参数
     * @param outOrderNo 订单号
     */
    private void updateOrderPayNo(PayParam payParam,String outOrderNo ){
        if(payParam.getOrderType().equals("ORDER")){
            orderService.update(new LambdaUpdateWrapper<Order>()
                    .eq(Order::getSn,payParam.getSn())
                    .set(Order::getPayOrderNo,outOrderNo));
        }else if(payParam.getOrderType().equals("TRADE")){
            orderService.update(new LambdaUpdateWrapper<Order>()
                    .eq(Order::getTradeSn,payParam.getSn())
                    .set(Order::getPayOrderNo,outOrderNo));
        }
    }
}
