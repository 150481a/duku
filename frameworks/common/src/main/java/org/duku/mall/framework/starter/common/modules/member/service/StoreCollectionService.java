package org.duku.mall.framework.starter.common.modules.member.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreCollection;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreCollectionVO;

public interface StoreCollectionService extends IService<StoreCollection> {

    /**
     * 店铺收藏分页
     * @param pageVo 分页VO
     * @return 店铺收藏分页列表
     */
    IPage<StoreCollectionVO> storeCollection(PageVO pageVo);

    /**
     * 是否收藏此店铺
     *
     * @param storeId 店铺ID
     * @return 是否收藏
     */
    boolean isCollection(String storeId);

    /**
     * 店铺商品收藏
     *
     * @param storeId 店铺ID
     * @return 操作状态
     */
    StoreCollection addStoreCollection(String storeId);

    /**
     * 店铺收藏
     *
     * @param storeId 店铺ID
     * @return 操作状态
     */
    boolean deleteStoreCollection(String storeId);
}
