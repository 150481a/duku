package org.duku.mall.framework.starter.common.modules.search.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.EsGoodsIndex;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.EsGoodsRelatedInfo;
import org.duku.mall.framework.starter.common.modules.search.entity.dto.EsGoodsSearchDTO;
import org.duku.mall.framework.starter.common.modules.search.service.EsGoodsSearchService;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsGoodsSearchServiceImpl implements EsGoodsSearchService {
    @Override
    public SearchPage<EsGoodsIndex> searchGoods(EsGoodsSearchDTO searchDTO, PageVO pageVo) {
        return null;
    }

    @Override
    public Page<EsGoodsIndex> searchGoodsByPage(EsGoodsSearchDTO searchDTO, PageVO pageVo) {
        return null;
    }

    @Override
    public EsGoodsRelatedInfo getSelector(EsGoodsSearchDTO goodsSearch, PageVO pageVo) {
        return null;
    }

    @Override
    public List<EsGoodsIndex> getEsGoodsBySkuIds(List<String> skuIds, PageVO pageVo) {
        return List.of();
    }

    @Override
    public EsGoodsIndex getEsGoodsById(String id) {
        return null;
    }
}
