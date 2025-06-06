package org.duku.mall.framework.starter.common.modules.wechat.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;
import org.duku.mall.framework.starter.common.modules.connect.entity.Connect;
import org.duku.mall.framework.starter.common.modules.connect.entity.enums.SourceEnum;
import org.duku.mall.framework.starter.common.modules.connect.service.ConnectService;
import org.duku.mall.framework.starter.common.modules.member.entity.dto.ConnectQueryDTO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderItem;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderItemService;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderService;
import org.duku.mall.framework.starter.common.modules.wechat.entity.dos.WechatMPMessage;
import org.duku.mall.framework.starter.common.modules.wechat.entity.dos.WechatMessage;
import org.duku.mall.framework.starter.common.modules.wechat.entity.enums.WechatMessageItemEnums;
import org.duku.mall.framework.starter.common.modules.wechat.service.WechatMPMessageService;
import org.duku.mall.framework.starter.common.modules.wechat.service.WechatMessageService;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.distributedid.toolkit.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class WechatMessageUtil {

    @Autowired
    private ConnectService connectService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private WechatAccessTokenUtil wechatAccessTokenUtil;
    @Autowired
    private WechatMessageService wechatMessageService;

    @Autowired
    private WechatMPMessageService wechatMPMessageService;

    public void sendWechatMessage(String sn) {
        try {
            this.wechatMessage(sn);
        } catch (Exception e) {
            log.error("微信公众号消息异常：", e);
        }
        try {
            this.wechatMpMessage(sn);
        } catch (Exception e) {
            log.error("小程序消息订阅异常：", e);
        }

    }

    /**
     * 发送微信消息
     *
     * @param sn
     */
    public void wechatMessage(String sn) {

        Order order = orderService.getBySn(sn);
        if (order == null) {
            throw new ServiceException("订单" + sn + "不存在，发送微信公众号消息错误");
        }
        if (ClientTypeEnum.H5.name().equals(order.getClientType())) {
            //获取微信消息
            LambdaQueryWrapper<WechatMessage> wechatMessageQueryWrapper = new LambdaQueryWrapper();
            wechatMessageQueryWrapper.eq(WechatMessage::getOrderStatus, order.getOrderStatus());
            WechatMessage wechatMessage = wechatMessageService.getOne(wechatMessageQueryWrapper);

            if (wechatMessage == null) {
                log.error("未配置微信公众号消息");
                return;
            }

            Connect connect = connectService.queryConnect(
                    ConnectQueryDTO.builder()
                            .userId(order.getMemberId())
                            .unionType(SourceEnum.WECHAT_OFFIACCOUNT_OPEN_ID.name())
                            .build()
            );
            if (connect == null) {
                return;
            }

            log.info("微信消息发送消息：{}", order.getMemberId() + "-" + sn);
            //获取token
            String token = wechatAccessTokenUtil.cgiAccessToken(ClientTypeEnum.H5);

            //发送url
            String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token;

            Map<String, Object> map = new HashMap<>(4);
            //用户id
            map.put("touser", connect.getUnionId());
            //模版id
            map.put("template_id", wechatMessage.getCode());
            //模版中所需数据
            map.put("data", createData(order, wechatMessage));

            log.info("参数内容：" + JSONUtil.toJsonStr(map));
            String content = HttpUtil.post(url, JSONUtil.toJsonStr(map));
            JSONObject json = new JSONObject(content);
            log.info("微信消息发送结果：" + content);
            String errorMessage = json.getStr("errmsg");
            String errcode = json.getStr("errcode");
            //发送失败
            if (!"0".equals(errcode)) {
                log.error("消息发送失败：" + errorMessage);
                log.error("消息发送请求token：" + token);
                log.error("消息发送请求：" + map.get("data"));
            }
        }
    }

    /**
     * 发送微信消息
     *
     * @param sn
     */
    public void wechatMpMessage(String sn) {

        log.info("发送消息订阅");
        Order order = orderService.getBySn(sn);
        if (order == null) {
            throw new ServiceException("订单" + sn + "不存在，发送订阅消息错误");
        }
        if (ClientTypeEnum.WECHAT_MP.name().equals(order.getClientType())) {

            //获取微信消息
            LambdaQueryWrapper<WechatMPMessage> wechatMPMessageQueryWrapper = new LambdaQueryWrapper();
            wechatMPMessageQueryWrapper.eq(WechatMPMessage::getOrderStatus, order.getOrderStatus());
            WechatMPMessage wechatMPMessage = wechatMPMessageService.getOne(wechatMPMessageQueryWrapper);
            if (wechatMPMessage == null) {
                log.info("未配置微信消息订阅");
                return;
            }

            Connect connect = connectService.queryConnect(
                    ConnectQueryDTO.builder().userId(order.getMemberId()).unionType(SourceEnum.WECHAT_MP_OPEN_ID.name()).build()
            );
            if (connect == null) {
                return;
            }

            log.info("微信消息订阅消息发送：{}", order.getMemberId() + "-" + sn);
            //获取token
            String token = wechatAccessTokenUtil.cgiAccessToken(ClientTypeEnum.WECHAT_MP);

            //发送url
            String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + token;

            Map<String, Object> map = new HashMap<>(4);
            //用户id
            map.put("touser", connect.getUnionId());
            //模版id
            map.put("template_id", wechatMPMessage.getCode());
            //模版中所需数据
            map.put("data", createData(order, wechatMPMessage));
            map.put("page", "pages/order/orderDetail?sn=" + order.getSn());
            log.info("参数内容：" + JSONUtil.toJsonStr(map));
            String content = null;
            try {
                content = HttpUtil.post(url, JSONUtil.toJsonStr(map));
            } catch (Exception e) {
                log.error("微信消息发送错误", e);
            }
            JSONObject json = new JSONObject(content);
            log.info("微信小程序消息发送结果：" + content);
            String errorMessage = json.getStr("errmsg");
            String errcode = json.getStr("errcode");
            //发送失败
            if (!"0".equals(errcode)) {
                log.error("消息发送失败：" + errorMessage);
                log.error("消息发送请求token：" + token);
                log.error("消息发送请求：" + map.get("data"));
            }
        }
    }

    /**
     * 构造数据中所需的内容
     *
     * @param order
     * @param wechatMessage
     * @return
     */
    private Map<String, Map<String, String>> createData(Order order, WechatMessage wechatMessage) {
        WechatMessageData wechatMessageData = new WechatMessageData();
        wechatMessageData.setFirst(wechatMessage.getFirst());
        wechatMessageData.setRemark(wechatMessage.getRemark());
        String[] paramArray = wechatMessage.getKeywords().split(",");
        LinkedList params = new LinkedList();

        for (String param : paramArray) {
            WechatMessageItemEnums wechatMessageItemEnums = WechatMessageItemEnums.valueOf(param);
            //初始化参数内容
            String val = getParams(wechatMessageItemEnums, order);
            params.add(val);
        }
        wechatMessageData.setMessageData(params);
        return wechatMessageData.createData();
    }

    /**
     * 构造数据中所需的内容
     *
     * @param order
     * @param wechatMPMessage
     * @return
     */
    private Map<String, Map<String, String>> createData(Order order, WechatMPMessage wechatMPMessage) {
        WechatMessageData wechatMessageData = new WechatMessageData();
        List<String> paramArray = JSONUtil.toList(wechatMPMessage.getKeywords(), String.class);
        List<String> texts = JSONUtil.toList(wechatMPMessage.getKeywordsText(), String.class);
        Map<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < paramArray.size(); i++) {
            WechatMessageItemEnums wechatMessageItemEnums = WechatMessageItemEnums.valueOf(paramArray.get(i));
            //初始化参数内容
            String val = getParams(wechatMessageItemEnums, order);
            val = StringUtils.subStringLength(val, 20);
            params.put(texts.get(i), val);
        }
        wechatMessageData.setMpMessageData(params);
        return wechatMessageData.createMPData();
    }

    /**
     * 获取具体参数
     *
     * @param itemEnums
     * @param order
     * @return
     */
    private String getParams(WechatMessageItemEnums itemEnums, Order order) {
        switch (itemEnums) {
            case PRICE:
                return order.getPriceDetailDTO().getFlowPrice().toString();
            case ORDER_SN:
                return order.getSn();
            case SHOP_NAME:
                return order.getStoreName();
            case GOODS_INFO:
                List<OrderItem> orderItems = orderItemService.getByOrderSn(order.getSn());
                StringBuffer stringBuffer = new StringBuffer();
                orderItems.forEach(orderItem -> {
                    stringBuffer.append(orderItem.getGoodsName() + "*" + orderItem.getNum() + "  ");
                });
                return stringBuffer.toString();
            case MEMBER_NAME:
                return order.getMemberName();
            case LOGISTICS_NO:
                return order.getLogisticsNo();
            case LOGISTICS_NAME:
                return order.getLogisticsName();
            case LOGISTICS_TIME:
                return DateUtil.toString(order.getLogisticsTime(), DateUtil.STANDARD_FORMAT);
            default:
                return "";
        }
    }

    /**
     * 如果返回信息有错误
     *
     * @param jsonObject 返回消息
     */
    public static void wechatHandler(JSONObject jsonObject) {
        if (jsonObject.containsKey("errmsg")) {
            if (("ok").equals(jsonObject.getStr("errmsg"))) {
                return;
            }
            log.error("微信接口异常，错误码" + jsonObject.get("errcode") + "，" + jsonObject.getStr("errmsg"));
            throw new ServiceException(ResultCode.WECHAT_ERROR);
        }
    }

    /**
     * 如果返回信息有错误
     *
     * @param string 返回消息
     */
    public static String wechatHandler(String string) {
        JSONObject jsonObject = new JSONObject();
        wechatHandler(jsonObject);
        return string;
    }
}
