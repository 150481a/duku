package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.Wholesale;
import org.duku.mall.framework.starter.common.modules.good.mapper.WholesaleMapper;
import org.duku.mall.framework.starter.common.modules.good.service.WholesaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WholesaleServiceImpl extends ServiceImpl<WholesaleMapper, Wholesale> implements WholesaleService {
    @Autowired
    private SingletonCache<List<Wholesale>> cache;

    @Override
    public List<Wholesale> findByGoodsId(String goodsId) {
        return List.of();
    }

    @Override
    public List<Wholesale> findByTemplateId(String templateId) {
        return List.of();
    }

    @Override
    public Boolean removeByGoodsId(String goodsId) {
        return null;
    }

    @Override
    public Boolean removeByTemplateId(String templateId) {
        return null;
    }

    @Override
    public Wholesale match(String goodsId, Integer num) {
        return null;
    }
}
