package org.duku.mall.framework.starter.common.modules.good.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.StoreGoodsLabel;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.StoreGoodsLabelVO;

import java.util.List;
import java.util.Map;

public interface StoreGoodsLabelService extends IService<StoreGoodsLabel> {

    /**
     * 根据商家ID获取店铺分类列表
     *
     * @param storeId 商家ID
     * @return 店铺分类列表
     */
    List<StoreGoodsLabelVO> listByStoreId(String storeId);

    /**
     * 根据分类id集合获取所有店铺分类根据层级排序
     *
     * @param ids 商家ID
     * @return 店铺分类列表
     */
    List<StoreGoodsLabel> listByStoreIds(List<String> ids);

    /**
     * 根据分类id集合获取所有店铺分类根据层级排序
     *
     * @param ids 商家ID
     * @return 店铺分类列表
     */
    List<Map<String, Object>> listMapsByStoreIds(List<String> ids, String columns);

    /**
     * 添加商品分类
     *
     * @param storeGoodsLabel 店铺商品分类
     * @return 店铺商品分类
     */
    StoreGoodsLabel addStoreGoodsLabel(StoreGoodsLabel storeGoodsLabel);

    /**
     * 修改商品分类
     *
     * @param storeGoodsLabel 店铺商品分类
     * @return 店铺商品分类
     */
    StoreGoodsLabel editStoreGoodsLabel(StoreGoodsLabel storeGoodsLabel);

    /**
     * 删除商品分类
     *
     * @param storeLabelId 店铺 分类 ID
     */
    void removeStoreGoodsLabel(String storeLabelId);
}
