package org.duku.mall.framework.starter.common.modules.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Store;
import org.duku.mall.framework.starter.common.modules.store.mapper.StoreMapper;
import org.duku.mall.framework.starter.common.modules.store.service.StoreService;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {
}
