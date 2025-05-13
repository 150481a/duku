package org.duku.mall.framework.starter.common.modules.distribution.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dos.DistributionGoods;
import org.duku.mall.framework.starter.common.modules.distribution.entity.params.DistributionGoodsSearchParams;
import org.duku.mall.framework.starter.common.modules.distribution.entity.vo.DistributionGoodsVO;
import org.duku.mall.framework.starter.common.modules.distribution.mapper.DistributionGoodsMapper;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionGoodsService;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionGoodsServiceImpl extends ServiceImpl<DistributionGoodsMapper, DistributionGoods> implements DistributionGoodsService {


    /**
     * 分销员
     */
    @Autowired
    private DistributionService distributionService;
    /**
     * 规格商品
     */
    @Autowired
    private GoodsSkuService goodsSkuService;

    @Override
    public IPage<DistributionGoodsVO> goodsPage(DistributionGoodsSearchParams distributionGoodsSearchParams) {
        return null;
    }

    @Override
    public List<DistributionGoods> getDistributionGoodsList(DistributionGoodsSearchParams distributionGoodsSearchParams) {
        return List.of();
    }

    @Override
    public DistributionGoods getDistributionGoods(DistributionGoodsSearchParams distributionGoodsSearchParams) {
        return null;
    }

    @Override
    public boolean deleteDistributionGoods(DistributionGoodsSearchParams distributionGoodsSearchParams) {
        return false;
    }

    @Override
    public DistributionGoods distributionGoodsVO(String id) {
        return null;
    }

    @Override
    public DistributionGoods distributionGoodsVOBySkuId(String skuId) {
        return null;
    }

    @Override
    public List<DistributionGoods> distributionGoods(List<String> skuIds) {
        return List.of();
    }

    @Override
    public DistributionGoods checked(String skuId, Double commission, String storeId) {
        return null;
    }
}
