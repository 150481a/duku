package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.alipay.api.domain.Goods;
import com.alipay.api.domain.GoodsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.GoodsOperationDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsAuthEnum;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsStatusEnum;
import org.duku.mall.framework.starter.common.modules.good.entity.params.GoodsSearchParams;
import org.duku.mall.framework.starter.common.modules.good.mapper.GoodsMapper;
import org.duku.mall.framework.starter.common.modules.good.service.*;
import org.duku.mall.framework.starter.common.modules.member.service.MemberEvaluationService;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Store;
import org.duku.mall.framework.starter.common.modules.store.service.FreightTemplateService;
import org.duku.mall.framework.starter.common.modules.store.service.StoreService;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl <GoodsMapper, Goods> implements GoodsService {


    /**
     * 分类
     */
    @Autowired
    private CategoryService categoryService;
    /**
     * 设置
     */
    @Autowired
    private SettingService settingService;
    /**
     * 商品相册
     */
    @Autowired
    private GoodsGalleryService goodsGalleryService;
    /**
     * 商品规格
     */
    @Autowired
    private GoodsSkuService goodsSkuService;
    /**
     * 店铺详情
     */
    @Autowired
    private StoreService storeService;
    /**
     * 会员评价
     */
    @Autowired
    private MemberEvaluationService memberEvaluationService;
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


    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private FreightTemplateService freightTemplateService;

    @Autowired
    private WholesaleService wholesaleService;

    @Autowired
    private SingletonCache<GoodsVO> cache;

    @Override
    public List<Goods> getByBrandIds(List<String> brandIds) {
        return List.of();
    }

    @Override
    public void underStoreGoods(String storeId) {

    }

    @Override
    public void updateGoodsParams(String goodsId, String params) {

    }

    @Override
    public long getGoodsCountByCategory(String categoryId) {
        return 0;
    }

    @Override
    public void addGoods(GoodsOperationDTO goodsOperationDTO) {

    }

    @Override
    public void editGoods(GoodsOperationDTO goodsOperationDTO, String goodsId) {

    }

    @Override
    public GoodsVO getGoodsVO(String goodsId) {
        return null;
    }

    @Override
    public IPage<Goods> queryByParams(GoodsSearchParams goodsSearchParams) {
        return null;
    }

    @Override
    public List<Goods> queryListByParams(GoodsSearchParams goodsSearchParams) {
        return List.of();
    }

    @Override
    public boolean auditGoods(List<String> goodsIds, GoodsAuthEnum goodsAuthEnum) {
        return false;
    }

    @Override
    public Boolean updateGoodsMarketAble(List<String> goodsIds, GoodsStatusEnum goodsStatusEnum, String underReason) {
        return null;
    }

    @Override
    public Boolean updateGoodsMarketAbleByStoreId(String storeId, GoodsStatusEnum goodsStatusEnum, String underReason) {
        return null;
    }

    @Override
    public Boolean managerUpdateGoodsMarketAble(List<String> goodsIds, GoodsStatusEnum goodsStatusEnum, String underReason) {
        return null;
    }

    @Override
    public Boolean deleteGoods(List<String> goodsIds) {
        return null;
    }

    @Override
    public Boolean freight(List<String> goodsIds, String templateId) {
        return null;
    }

    @Override
    public void updateStock(String goodsId) {

    }

    @Override
    public void updateGoodsCommentNum(String goodsId, String skuId) {

    }

    @Override
    public void updateGoodsBuyCount(String goodsId, int buyCount) {

    }

    @Override
    public void updateStoreDetail(Store store) {

    }

    @Override
    public long countStoreGoodsNum(String storeId) {
        return 0;
    }

    @Override
    public void categoryGoodsName(String categoryId) {

    }

    @Override
    public void addGoodsCommentNum(Integer commentNum, String goodsId) {

    }
}
