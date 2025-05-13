package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreCollection;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreCollectionVO;
import org.duku.mall.framework.starter.common.modules.member.mapper.StoreCollectionMapper;
import org.duku.mall.framework.starter.common.modules.member.service.StoreCollectionService;
import org.duku.mall.framework.starter.common.modules.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreCollectionServiceImpl extends ServiceImpl<StoreCollectionMapper, StoreCollection> implements StoreCollectionService {


    @Autowired
    private StoreService storeService;

    @Override
    public IPage<StoreCollectionVO> storeCollection(PageVO pageVo) {
        return null;
    }

    @Override
    public boolean isCollection(String storeId) {
        return false;
    }

    @Override
    public StoreCollection addStoreCollection(String storeId) {
        return null;
    }

    @Override
    public boolean deleteStoreCollection(String storeId) {
        return false;
    }
}
