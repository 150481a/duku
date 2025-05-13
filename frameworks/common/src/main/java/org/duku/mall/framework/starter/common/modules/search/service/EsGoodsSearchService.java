package org.duku.mall.framework.starter.common.modules.search.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.EsGoodsIndex;
import org.duku.mall.framework.starter.common.modules.search.entity.dos.EsGoodsRelatedInfo;
import org.duku.mall.framework.starter.common.modules.search.entity.dto.EsGoodsSearchDTO;
import org.springframework.data.elasticsearch.core.SearchPage;

import java.util.List;

public interface EsGoodsSearchService  {

    /**
     * 商品搜索
     *
     * @param searchDTO 搜索参数
     * @param pageVo    分页参数
     * @return 搜索结果
     */
    SearchPage<EsGoodsIndex> searchGoods(EsGoodsSearchDTO searchDTO, PageVO pageVo);

    /**
     * 商品搜索
     *
     * @param searchDTO 搜索参数
     * @param pageVo    分页参数
     * @return 搜索结果
     */
    Page<EsGoodsIndex> searchGoodsByPage(EsGoodsSearchDTO searchDTO, PageVO pageVo);

    /**
     * 获取筛选器
     *
     * @param goodsSearch 搜索条件
     * @param pageVo      分页参数
     * @return ES商品关联
     */
    EsGoodsRelatedInfo getSelector(EsGoodsSearchDTO goodsSearch, PageVO pageVo);

    /**
     * 根据SkuID列表获取ES商品
     *
     * @param skuIds SkuId列表
     * @return ES商品列表
     */
    List<EsGoodsIndex> getEsGoodsBySkuIds(List<String> skuIds, PageVO pageVo);

    /**
     * 根据id获取商品索引
     *
     * @param id 商品skuId
     * @return 商品索引
     */
    EsGoodsIndex getEsGoodsById(String id);
}
