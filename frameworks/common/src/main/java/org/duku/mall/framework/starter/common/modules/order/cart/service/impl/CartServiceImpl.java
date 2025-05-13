package org.duku.mall.framework.starter.common.modules.order.cart.service.impl;

import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsSkuService;
import org.duku.mall.framework.starter.common.modules.good.service.WholesaleService;
import org.duku.mall.framework.starter.common.modules.member.service.MemberAddressService;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.dto.TradeDTO;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.enums.CartTypeEnum;
import org.duku.mall.framework.starter.common.modules.order.cart.entity.params.TradeParams;
import org.duku.mall.framework.starter.common.modules.order.cart.render.TradeBuilder;
import org.duku.mall.framework.starter.common.modules.order.cart.service.CartService;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.Trade;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.ReceiptVO;
import org.duku.mall.framework.starter.common.modules.promotion.service.KanjiaActivityService;
import org.duku.mall.framework.starter.common.modules.promotion.service.MemberCouponService;
import org.duku.mall.framework.starter.common.modules.promotion.service.PointsGoodsService;
import org.duku.mall.framework.starter.common.modules.promotion.service.PromotionGoodsService;
import org.duku.mall.framework.starter.common.modules.search.service.EsGoodsSearchService;
import org.duku.mall.framework.starter.common.modules.store.service.StoreAddressService;
import org.duku.mall.framework.starter.common.modules.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    static String errorMessage = "购物车异常，请稍后重试";

    /**
     * 缓存
     */
    @Autowired
    private SingletonCache<Object> cache;
    /**
     * 会员优惠券
     */
    @Autowired
    private MemberCouponService memberCouponService;
    /**
     * 规格商品
     */
    @Autowired
    private GoodsSkuService goodsSkuService;
    /**
     * 促销商品
     */
    @Autowired
    private PointsGoodsService pointsGoodsService;
    /**
     * 会员地址
     */
    @Autowired
    private MemberAddressService memberAddressService;
    /**
     * ES商品
     */
    @Autowired
    private EsGoodsSearchService esGoodsSearchService;
    /**
     * 砍价
     */
    @Autowired
    private KanjiaActivityService kanjiaActivityService;
    /**
     * 交易
     */
    @Autowired
    private TradeBuilder tradeBuilder;

    @Autowired
    private MemberService memberService;

    @Autowired
    private PromotionGoodsService promotionGoodsService;

    @Autowired
    private WholesaleService wholesaleService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreAddressService storeAddressService;

    @Override
    public TradeDTO readDTO(CartTypeEnum checkedWay) {
        return null;
    }

    @Override
    public TradeDTO getCheckedTradeDTO(CartTypeEnum way) {
        return null;
    }

    @Override
    public Long getCanUseCoupon(CartTypeEnum checkedWay) {
        return 0L;
    }

    @Override
    public TradeDTO getAllTradeDTO() {
        return null;
    }

    @Override
    public void add(String skuId, Integer num, String cartType, Boolean cover) {

    }

    @Override
    public void checked(String skuId, boolean checked) {

    }

    @Override
    public void checkedStore(String storeId, boolean checked) {

    }

    @Override
    public void checkedAll(boolean checked) {

    }

    @Override
    public void delete(String[] skuIds) {

    }

    @Override
    public void clean() {

    }

    @Override
    public void resetTradeDTO(TradeDTO tradeDTO) {

    }

    @Override
    public void shippingAddress(String shippingAddressId, String way) {

    }

    @Override
    public void shippingSelfAddress(String shopAddressId, String way) {

    }

    @Override
    public void shippingReceipt(ReceiptVO receiptVO, String way) {

    }

    @Override
    public void shippingMethod(String deliveryMethod, String way) {

    }

    @Override
    public Long getCartNum(Boolean checked) {
        return 0L;
    }

    @Override
    public void selectCoupon(String couponId, String way, boolean use) {

    }

    @Override
    public Trade createTrade(TradeParams tradeParams) {
        return null;
    }

    @Override
    public List<String> shippingMethodList(String way) {
        return List.of();
    }
}
