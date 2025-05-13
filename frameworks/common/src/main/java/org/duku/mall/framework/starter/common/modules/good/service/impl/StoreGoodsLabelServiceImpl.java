package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.StoreGoodsLabel;
import org.duku.mall.framework.starter.common.modules.good.entity.vo.StoreGoodsLabelVO;
import org.duku.mall.framework.starter.common.modules.good.mapper.StoreGoodsLabelMapper;
import org.duku.mall.framework.starter.common.modules.good.service.StoreGoodsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreGoodsLabelServiceImpl extends ServiceImpl <StoreGoodsLabelMapper, StoreGoodsLabel> implements StoreGoodsLabelService {

    /**
     * 缓存
     */
    @Autowired
    private SingletonCache cache;

    @Override
    public List<StoreGoodsLabelVO> listByStoreId(String storeId) {
        return List.of();
    }

    @Override
    public List<StoreGoodsLabel> listByStoreIds(List<String> ids) {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> listMapsByStoreIds(List<String> ids, String columns) {
        return List.of();
    }

    @Override
    public StoreGoodsLabel addStoreGoodsLabel(StoreGoodsLabel storeGoodsLabel) {
        return null;
    }

    @Override
    public StoreGoodsLabel editStoreGoodsLabel(StoreGoodsLabel storeGoodsLabel) {
        return null;
    }

    @Override
    public void removeStoreGoodsLabel(String storeLabelId) {

    }
}
