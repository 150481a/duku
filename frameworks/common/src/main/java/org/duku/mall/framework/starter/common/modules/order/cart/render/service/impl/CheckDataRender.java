package org.duku.mall.framework.starter.common.modules.order.cart.render.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.convention.enums.PromotionTypeEnum;
import org.duku.mall.framework.starter.convention.enums.ResultCode;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.common.common.utils.CurrencyUtil;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsSku;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Wholesale;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsAuthEnum;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsSalesModeEnum;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsStatusEnum;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsSkuService;
import org.duku.mall.framework.starter.common.modules.good.service.WholesaleService;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Member;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.TradeDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.enums.CartTypeEnum;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.enums.DeliveryMethodEnum;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.enums.RenderStepEnums;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.vo.CartSkuVO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.vo.CartVO;
import org.duku.mall.framework.starter.common.modules.order.cart.render.service.CartRenderStep;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Order;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderService;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Coupon;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Pintuan;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.PointsGoods;
import org.duku.mall.framework.starter.common.modules.promotion.entity.vos.CouponVO;
import org.duku.mall.framework.starter.common.modules.promotion.service.PromotionGoodsService;
import org.duku.mall.framework.starter.user.core.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CheckDataRender implements CartRenderStep {


    @Autowired
    private GoodsSkuService goodsSkuService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private WholesaleService wholesaleService;

    /**
     * 商品索引
     */
    @Autowired
    private PromotionGoodsService promotionGoodsService;

    @Override
    public RenderStepEnums step() {
        return RenderStepEnums.CHECK_DATA;
    }

    @Override
    public void render(TradeDTO tradeDTO) {


        //校验商品有效性
        checkData(tradeDTO);

        //预校验
        preCalibration(tradeDTO);

        //批量销售预处理
        preSaleModel(tradeDTO);

        //店铺分组数据初始化
        groupStore(tradeDTO);

    }

    /**
     * 校验商品属性
     *
     * @param tradeDTO 购物车视图
     */
    private void checkData(TradeDTO tradeDTO) {
        List<CartSkuVO> cartSkuVOS = tradeDTO.getSkuList();

        //循环购物车中的商品
        for (CartSkuVO cartSkuVO : cartSkuVOS) {

            //如果失效，确认sku为未选中状态
            if (Boolean.TRUE.equals(cartSkuVO.getInvalid())) {
                //设置购物车未选中
                cartSkuVO.setChecked(false);
            }

            //缓存中的商品信息
            GoodsSku dataSku = goodsSkuService.getGoodsSkuByIdFromCache(cartSkuVO.getGoodsSku().getId());

            //商品上架状态判定  sku为空、sku非上架状态、sku审核不通过
            boolean checkGoodsStatus = dataSku == null || !GoodsAuthEnum.PASS.name().equals(dataSku.getAuthFlag()) || !GoodsStatusEnum.UPPER.name().equals(dataSku.getMarketEnable());
            //商品有效性判定 sku不为空且sku的更新时间不为空且sku的更新时间在购物车sku的更新时间之后
            boolean checkGoodsValid = dataSku != null &&
                    dataSku.getUpdateTime() != null &&
                    cartSkuVO.getGoodsSku() != null &&
                    cartSkuVO.getGoodsSku().getUpdateTime() != null &&
                    dataSku.getUpdateTime().after(cartSkuVO.getGoodsSku().getUpdateTime());


            if (checkGoodsStatus || checkGoodsValid) {
                if (checkGoodsValid) {
                    cartSkuVO.rebuildBySku(dataSku);
                }
                if (checkGoodsStatus) {
                    //设置购物车未选中
                    cartSkuVO.setChecked(false);
                    //设置购物车此sku商品已失效
                    cartSkuVO.setInvalid(true);
                    //设置失效消息
                    cartSkuVO.setErrorMessage("商品已下架");
                    continue;
                }

            }

            //商品库存判定
            if (dataSku.getQuantity() < cartSkuVO.getNum()) {
                //设置购物车未选中
                cartSkuVO.setChecked(false);
                //设置失效消息
                cartSkuVO.setErrorMessage("商品库存不足,现有库存数量[" + dataSku.getQuantity() + "]");
            }
            //如果存在商品促销活动，则判定商品促销状态
            if (!cartSkuVO.getCartType().equals(CartTypeEnum.POINTS) && (CollUtil.isNotEmpty(cartSkuVO.getNotFilterPromotionMap()) || Boolean.TRUE.equals(cartSkuVO.getGoodsSku().getPromotionFlag()))) {
                //获取当前最新的促销信息
                cartSkuVO.setPromotionMap(this.promotionGoodsService.getCurrentGoodsPromotion(cartSkuVO.getGoodsSku(), tradeDTO.getCartTypeEnum().name()));
                //设定商品价格
                Double goodsPrice = cartSkuVO.getGoodsSku().getPromotionFlag() != null && cartSkuVO.getGoodsSku().getPromotionFlag() ? cartSkuVO.getGoodsSku().getPromotionPrice() : cartSkuVO.getGoodsSku().getPrice();
                cartSkuVO.setPurchasePrice(goodsPrice);
                cartSkuVO.setUtilPrice(goodsPrice);
                cartSkuVO.setSubTotal(CurrencyUtil.mul(cartSkuVO.getPurchasePrice(), cartSkuVO.getNum()));
            }

        }
    }

    /**
     * 店铺分组
     *
     * @param tradeDTO
     */
    private void groupStore(TradeDTO tradeDTO) {
        //渲染的购物车
        List<CartVO> cartList = new ArrayList<>();
        if (tradeDTO.getCartList() == null || tradeDTO.getCartList().size() == 0) {
            //根据店铺分组
            Map<String, List<CartSkuVO>> storeCollect = tradeDTO.getSkuList().stream().collect(Collectors.groupingBy(CartSkuVO::getStoreId));
            for (Map.Entry<String, List<CartSkuVO>> storeCart : storeCollect.entrySet()) {
                if (!storeCart.getValue().isEmpty()) {
                    CartVO cartVO = new CartVO(storeCart.getValue().get(0));
                    if (CharSequenceUtil.isEmpty(cartVO.getDeliveryMethod())) {
                        cartVO.setDeliveryMethod(DeliveryMethodEnum.LOGISTICS.name());
                    }
                    cartVO.setSkuList(storeCart.getValue());
                    try {
                        //筛选属于当前店铺的优惠券
                        storeCart.getValue().forEach(i -> i.getPromotionMap().forEach((key, value) -> {
                            if (key.contains(PromotionTypeEnum.COUPON.name())) {
                                JSONObject promotionsObj = JSONUtil.parseObj(value);
                                Coupon coupon = JSONUtil.toBean(promotionsObj, Coupon.class);
                                if (key.contains(PromotionTypeEnum.COUPON.name()) && coupon.getStoreId().equals(storeCart.getKey())) {
                                    cartVO.getCanReceiveCoupon().add(new CouponVO(coupon));
                                }
                            }
                        }));
                    } catch (Exception e) {
                        log.error("筛选属于当前店铺的优惠券发生异常！", e);
                    }
                    storeCart.getValue().stream().filter(i -> Boolean.TRUE.equals(i.getChecked())).findFirst().ifPresent(cartSkuVO -> cartVO.setChecked(true));
                    cartList.add(cartVO);
                }
            }
            tradeDTO.setCartList(cartList);
        }

    }

    /**
     * 订单预校验
     * 1、自己拼团自己创建都拼团判定、拼团限购
     * 2、积分购买，积分足够与否
     *
     * @param tradeDTO
     */
    private void preCalibration(TradeDTO tradeDTO) {

        //拼团订单预校验
        if (tradeDTO.getCartTypeEnum().equals(CartTypeEnum.PINTUAN)) {
            //拼团判定，不能参与自己创建的拼团
            if (tradeDTO.getParentOrderSn() != null) {
                //订单接收
                Order parentOrder = orderService.getBySn(tradeDTO.getParentOrderSn());
                //参与活动判定
                if (parentOrder.getMemberId().equals(UserContext.getCurrentUser().getUserId())) {
                    throw new ServiceException(ResultCode.PINTUAN_JOIN_ERROR);
                }
            }
            //判断拼团商品的限购数量
            if (tradeDTO.getSkuList().get(0).getPromotionMap() != null && !tradeDTO.getSkuList().get(0).getPromotionMap().isEmpty()) {
                Optional<Map.Entry<String, Object>> pintuanPromotions = tradeDTO.getSkuList().get(0).getPromotionMap().entrySet().stream().filter(i -> i.getKey().contains(PromotionTypeEnum.PINTUAN.name())).findFirst();
                if (pintuanPromotions.isPresent()) {
                    JSONObject promotionsObj = JSONUtil.parseObj(pintuanPromotions.get().getValue());
                    Pintuan pintuan = promotionsObj.toBean(Pintuan.class);
                    Integer limitNum = pintuan.getLimitNum();
                    for (CartSkuVO cartSkuVO : tradeDTO.getSkuList()) {
                        if (limitNum != 0 && cartSkuVO.getNum() > limitNum) {
                            throw new ServiceException(ResultCode.PINTUAN_LIMIT_NUM_ERROR);
                        }
                    }
                }
            }
            //积分商品，判断用户积分是否满足
        } else if (tradeDTO.getCartTypeEnum().equals(CartTypeEnum.POINTS) && tradeDTO.getSkuList().get(0).getPromotionMap() != null && !tradeDTO.getSkuList().get(0).getPromotionMap().isEmpty()) {
            //获取积分商品VO
            Optional<Map.Entry<String, Object>> pointsPromotions = tradeDTO.getSkuList().get(0).getPromotionMap().entrySet().stream().filter(i -> i.getKey().contains(PromotionTypeEnum.POINTS_GOODS.name())).findFirst();
            if (pointsPromotions.isPresent()) {
                JSONObject promotionsObj = JSONUtil.parseObj(pointsPromotions.get().getValue());
                PointsGoods pointsGoods = promotionsObj.toBean(PointsGoods.class);
                if (pointsGoods == null) {
                    throw new ServiceException(ResultCode.POINT_GOODS_ERROR);
                }
                Member member = memberService.getUserInfo();
                if (member.getPoint() < pointsGoods.getPoints()) {
                    throw new ServiceException(ResultCode.USER_POINTS_ERROR);
                }
            }

        }

    }


    /**
     * 商品销售模式特殊处理
     *
     * @param tradeDTO 交易信息
     */
    private void preSaleModel(TradeDTO tradeDTO) {
        // 寻找同goods下销售模式为批发的商品
        Map<String, List<CartSkuVO>> goodsGroup = tradeDTO.getCheckedSkuList().stream().filter(i -> i.getGoodsSku().getSalesModel().equals(GoodsSalesModeEnum.WHOLESALE.name())).collect(Collectors.groupingBy(i -> i.getGoodsSku().getGoodsId()));
        if (CollUtil.isNotEmpty(goodsGroup)) {
            goodsGroup.forEach((k, v) -> {
                // 获取购买总数
                int sum = v.stream().filter(i -> Boolean.TRUE.equals(i.getChecked())).mapToInt(CartSkuVO::getNum).sum();
                int fSum = v.stream().filter(i -> Boolean.FALSE.equals(i.getChecked())).mapToInt(CartSkuVO::getNum).sum();
                // 匹配符合的批发规则
                Wholesale match = wholesaleService.match(k, sum);
                if (match != null) {
                    v.forEach(i -> {
                        // 将符合规则的商品设置批发价格
                        if (Boolean.TRUE.equals(i.getChecked())) {
                            i.setPurchasePrice(match.getPrice());
                            i.getGoodsSku().setPrice(match.getPrice());
                            i.getGoodsSku().setCost(match.getPrice());
                            i.setUtilPrice(match.getPrice());
                            i.setSubTotal(CurrencyUtil.mul(i.getPurchasePrice(), i.getNum()));
                        } else {
                            i.setPurchasePrice(wholesaleService.match(k, fSum).getPrice());
                            i.getGoodsSku().setPrice(i.getPurchasePrice());
                            i.getGoodsSku().setCost(i.getPurchasePrice());
                            i.setUtilPrice(i.getPurchasePrice());
                            i.setSubTotal(CurrencyUtil.mul(i.getPurchasePrice(), i.getNum()));
                        }
                    });
                }
            });
        }
    }
}
