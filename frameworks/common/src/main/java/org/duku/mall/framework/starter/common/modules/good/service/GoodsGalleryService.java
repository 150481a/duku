package org.duku.mall.framework.starter.common.modules.good.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.GoodsGallery;

import java.util.List;

public interface GoodsGalleryService extends IService<GoodsGallery> {
    /**
     * 添加商品相册
     *
     * @param goodsGalleryList 商品相册列表
     * @param goodsId          商品ID
     */
    void add(List<String> goodsGalleryList, String goodsId);

    /**
     * 根据原图获取缩略图
     *
     * @param origin 原图地址
     * @return 商品相册
     */
    GoodsGallery getGoodsGallery(String origin);

    /**
     * 根据商品 id查询商品相册原图
     *
     * @param goodsId 商品ID
     * @return 商品相册列表
     */
    List<GoodsGallery> goodsGalleryList(String goodsId);

    /**
     * 根据商品 id删除商品相册缩略图
     *
     * @param goodsId 商品ID
     */
    void removeByGoodsId(String goodsId);
}
