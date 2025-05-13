package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.DraftGoods;
import org.duku.mall.framework.starter.common.modules.good.entity.dto.DraftGoodsDTO;
import org.duku.mall.framework.starter.common.modules.good.entity.params.DraftGoodsSearchParams;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.DraftGoodsVO;
import org.duku.mall.framework.starter.common.modules.good.mapper.DraftGoodsMapper;
import org.duku.mall.framework.starter.common.modules.good.service.CategoryService;
import org.duku.mall.framework.starter.common.modules.good.service.DraftGoodsService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsGalleryService;
import org.duku.mall.framework.starter.common.modules.good.service.GoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DraftGoodsServiceImpl extends ServiceImpl<DraftGoodsMapper, DraftGoods> implements DraftGoodsService {

    /**
     * 分类
     */
    @Autowired
    private CategoryService categoryService;
    /**
     * 商品相册
     */
    @Autowired
    private GoodsGalleryService goodsGalleryService;
    /**
     * 规格商品
     */
    @Autowired
    private GoodsSkuService goodsSkuService;

    @Autowired
    private WholesaleService wholesaleService;

    @Override
    public boolean addGoodsDraft(DraftGoodsDTO draftGoods) {
        return false;
    }

    @Override
    public boolean updateGoodsDraft(DraftGoodsDTO draftGoods) {
        return false;
    }

    @Override
    public void saveGoodsDraft(DraftGoodsDTO draftGoodsVO) {

    }

    @Override
    public void deleteGoodsDraft(String id) {

    }

    @Override
    public DraftGoodsVO getDraftGoods(String id) {
        return null;
    }

    @Override
    public IPage<DraftGoods> getDraftGoods(DraftGoodsSearchParams searchParams) {
        return null;
    }
}
