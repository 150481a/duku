package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.GoodsCollection;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.GoodsCollectionVO;
import org.duku.mall.framework.starter.common.modules.member.mapper.GoodsCollectionMapper;
import org.duku.mall.framework.starter.common.modules.member.service.GoodsCollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsCollectionServiceImpl extends ServiceImpl<GoodsCollectionMapper, GoodsCollection> implements GoodsCollectionService {
    @Override
    public IPage<GoodsCollectionVO> goodsCollection(PageVO pageVo) {
        return null;
    }

    @Override
    public boolean isCollection(String skuId) {
        return false;
    }

    @Override
    public GoodsCollection addGoodsCollection(String skuId) {
        return null;
    }

    @Override
    public boolean deleteGoodsCollection(String skuId) {
        return false;
    }

    @Override
    public boolean deleteGoodsCollection(List<String> goodsIds) {
        return false;
    }

    @Override
    public boolean deleteSkuCollection(List<String> skuIds) {
        return false;
    }
}
