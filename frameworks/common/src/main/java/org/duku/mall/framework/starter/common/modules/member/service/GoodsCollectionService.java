package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.GoodsCollection;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.GoodsCollectionVO;

import java.util.List;

public interface GoodsCollectionService extends IService<GoodsCollection> {

    /**
     * 获取商品搜索分页
     *
     * @param pageVo 查询参数
     * @return 商品搜索分页
     */
    IPage<GoodsCollectionVO> goodsCollection(PageVO pageVo);

    /**
     * 是否收藏商品
     *
     * @param skuId 规格ID
     * @return 是否收藏
     */
    boolean isCollection(String skuId);

    /**
     * 添加商品收藏
     *
     * @param skuId 规格ID
     * @return 操作状态
     */
    GoodsCollection addGoodsCollection(String skuId);

    /**
     * 商品收藏
     *
     * @param skuId 规格ID
     * @return 操作状态
     */
    boolean deleteGoodsCollection(String skuId);
    /**
     * 删除商品收藏
     *
     * @param goodsIds 规格ID
     * @return 操作状态
     */
    boolean deleteGoodsCollection(List<String> goodsIds);
    /**
     * 删除商品SKU收藏
     *
     * @param skuIds 规格ID
     * @return 操作状态
     */
    boolean deleteSkuCollection(List<String> skuIds);
}
