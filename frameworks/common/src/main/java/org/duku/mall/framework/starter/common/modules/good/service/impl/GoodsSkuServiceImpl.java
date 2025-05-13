package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.alipay.api.domain.Goods;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsSku;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsOperationDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsSkuDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsSkuStockDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.params.GoodsSearchParams;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.GoodsSkuVO;
import org.duku.mall.framework.starter.common.modules.good.mapper.GoodsSkuMapper;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsGalleryService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsSkuService;
import org.duku.mall.framework.starter.common.modules.good.service.WholesaleService;
import org.duku.mall.framework.starter.common.modules.good.sku.render.SalesModelRender;
import org.duku.mall.framework.starter.common.modules.promotion.service.CouponService;
import org.duku.mall.framework.starter.common.modules.promotion.service.MemberCouponService;
import org.duku.mall.framework.starter.common.modules.promotion.service.PromotionGoodsService;
import org.duku.mall.framework.starter.common.modules.search.service.EsGoodsIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class GoodsSkuServiceImpl extends ServiceImpl<GoodsSkuMapper, GoodsSku> implements GoodsSkuService {

    /**
     * 缓存
     */
    @Autowired
    private SingletonCache cache;
    /**
     * 分类
     */
    @Autowired
    private MemberCouponService memberCouponService;
    /**
     * 商品相册
     */
    @Autowired
    private GoodsGalleryService goodsGalleryService;
    /**
     * rocketMq
     */
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    /**
     * rocketMq配置
     */
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;
    /**
     * 商品
     */
    @Autowired
    private GoodsService goodsService;
    /**
     * 商品索引
     */
    @Autowired
    private EsGoodsIndexService goodsIndexService;

    @Autowired
    private PromotionGoodsService promotionGoodsService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private WholesaleService wholesaleService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private List<SalesModelRender> salesModelRenders;

    @Override
    public void add(Goods goods, GoodsOperationDTO goodsOperationDTO) {

    }

    @Override
    public void update(Goods goods, GoodsOperationDTO goodsOperationDTO) {

    }

    @Override
    public void update(GoodsSku goodsSku) {

    }

    @Override
    public void clearCache(String skuId) {

    }

    @Override
    public GoodsSku getGoodsSkuByIdFromCache(String id) {
        return null;
    }

    @Override
    public GoodsSku getCanPromotionGoodsSkuByIdFromCache(String skuId) {
        return null;
    }

    @Override
    public Map<String, Object> getGoodsSkuDetail(String goodsId, String skuId) {
        return Map.of();
    }

    @Override
    public List<GoodsSku> getGoodsSkuByIdFromCache(List<String> ids) {
        return List.of();
    }

    @Override
    public List<GoodsSkuVO> getGoodsListByGoodsId(String goodsId) {
        return List.of();
    }

    @Override
    public List<GoodsSku> getGoodsSkuListByGoodsId(String goodsId) {
        return List.of();
    }

    @Override
    public List<GoodsSkuVO> getGoodsSkuVOList(List<GoodsSku> list) {
        return List.of();
    }

    @Override
    public GoodsSkuVO getGoodsSkuVO(GoodsSku goodsSku) {
        return null;
    }

    @Override
    public IPage<GoodsSku> getGoodsSkuByPage(GoodsSearchParams searchParams) {
        return null;
    }

    @Override
    public void queryExportStock(HttpServletResponse response, GoodsSearchParams searchParams) {

    }

    @Override
    public void importStock(String storeId, MultipartFile files) {

    }

    @Override
    public IPage<GoodsSkuDTO> getGoodsSkuDTOByPage(Page<GoodsSkuDTO> page, Wrapper<GoodsSkuDTO> queryWrapper) {
        return null;
    }

    @Override
    public List<GoodsSku> getGoodsSkuByList(GoodsSearchParams searchParams) {
        return List.of();
    }

    @Override
    public void updateGoodsSkuStatus(Goods goods) {

    }

    @Override
    public void updateGoodsSkuStatusByStoreId(String storeId, String marketEnable, String authFlag) {

    }

    @Override
    public void updateStocks(List<GoodsSkuStockDTO> goodsSkuStockDTOS) {

    }

    @Override
    public void updateStocksByType(List<GoodsSkuStockDTO> goodsSkuStockDTOS) {

    }

    @Override
    public void batchUpdateAlertQuantity(List<GoodsSkuStockDTO> goodsSkuStockDTOS) {

    }

    @Override
    public void updateAlertQuantity(GoodsSkuStockDTO goodsSkuStockDTO) {

    }

    @Override
    public void updateStock(String skuId, Integer quantity) {

    }

    @Override
    public void updateStock(String skuId, Integer quantity, String type) {

    }

    @Override
    public Integer getStock(String skuId) {
        return 0;
    }

    @Override
    public void updateGoodsStock(List<GoodsSku> goodsSkus) {

    }

    @Override
    public List<String> getSkuIdsByGoodsId(String goodsId) {
        return List.of();
    }

    @Override
    public boolean deleteAndInsertGoodsSkus(List<GoodsSku> goodsSkus) {
        return false;
    }

    @Override
    public Long countSkuNum(String storeId) {
        return 0L;
    }

    @Override
    public void renderGoodsSkuList(List<GoodsSku> goodsSkuList, GoodsOperationDTO goodsOperationDTO) {

    }

    @Override
    public void updateGoodsSkuBuyCount(String skuId, int buyCount) {

    }

    @Override
    public void updateGoodsSkuGrade(String goodsId, double grade, int commentNum) {

    }

    @Override
    public Integer getGoodsStock(String goodsId) {
        return 0;
    }

    @Override
    public Boolean freight(List<String> goodsId, String templateId) {
        return null;
    }
}
