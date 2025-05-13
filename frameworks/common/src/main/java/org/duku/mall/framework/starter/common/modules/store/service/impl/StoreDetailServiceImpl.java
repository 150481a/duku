package org.duku.mall.framework.starter.common.modules.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.StoreDetail;
import org.duku.mall.framework.starter.common.modules.store.mapper.StoreDetailMapper;
import org.duku.mall.framework.starter.common.modules.store.service.StoreDetailService;
import org.springframework.stereotype.Service;

@Service
public class StoreDetailServiceImpl extends ServiceImpl<StoreDetailMapper, StoreDetail> implements StoreDetailService {
}
