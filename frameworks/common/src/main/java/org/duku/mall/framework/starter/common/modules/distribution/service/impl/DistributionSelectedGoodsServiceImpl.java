package org.duku.mall.framework.starter.common.modules.distribution.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dos.DistributionSelectedGoods;
import org.duku.mall.framework.starter.common.modules.distribution.mapper.DistributionSelectedGoodsMapper;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionSelectedGoodsService;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistributionSelectedGoodsServiceImpl extends ServiceImpl<DistributionSelectedGoodsMapper, DistributionSelectedGoods> implements DistributionSelectedGoodsService {

    /**
     * 分销员
     */
    @Autowired
    private DistributionService distributionService;
    @Override
    public boolean add(String distributionGoodsId) {
        return false;
    }

    @Override
    public boolean delete(String distributionGoodsId) {
        return false;
    }

    @Override
    public boolean deleteByDistributionGoodsId(String distributionGoodsId) {
        return false;
    }
}
