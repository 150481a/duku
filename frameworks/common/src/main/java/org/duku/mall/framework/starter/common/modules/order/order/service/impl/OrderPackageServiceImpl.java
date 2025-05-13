package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderPackage;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderPackageVO;
import org.duku.mall.framework.starter.common.modules.order.order.mapper.OrderPackageMapper;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderPackageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPackageServiceImpl extends ServiceImpl<OrderPackageMapper, OrderPackage> implements OrderPackageService {
    @Override
    public List<OrderPackage> orderPackageList(String orderSn) {
        return List.of();
    }

    @Override
    public List<OrderPackageVO> getOrderPackageVOList(String orderSn) {
        return List.of();
    }
}
