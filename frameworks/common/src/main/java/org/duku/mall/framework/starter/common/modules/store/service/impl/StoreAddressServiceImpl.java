package org.duku.mall.framework.starter.common.modules.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.StoreAddress;
import org.duku.mall.framework.starter.common.modules.store.mapper.StoreAddressMapper;
import org.duku.mall.framework.starter.common.modules.store.service.StoreAddressService;
import org.springframework.stereotype.Service;

@Service
public class StoreAddressServiceImpl extends ServiceImpl <StoreAddressMapper, StoreAddress> implements StoreAddressService {
}
