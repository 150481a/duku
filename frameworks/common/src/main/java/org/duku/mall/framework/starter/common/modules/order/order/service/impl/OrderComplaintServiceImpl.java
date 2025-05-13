package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderComplaint;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dto.OrderComplaintDTO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.params.OrderComplaintOperationParams;
import org.duku.mall.framework.starter.common.modules.order.order.entity.params.OrderComplaintSearchParams;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderComplaintVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.StoreAppealVO;
import org.duku.mall.framework.starter.common.modules.order.order.mapper.OrderComplaintMapper;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderComplaintService;
import org.springframework.stereotype.Service;

@Service
public class OrderComplaintServiceImpl extends ServiceImpl <OrderComplaintMapper, OrderComplaint> implements OrderComplaintService {
    @Override
    public IPage<OrderComplaint> getOrderComplainByPage(OrderComplaintSearchParams searchParams, PageVO pageVO) {
        return null;
    }

    @Override
    public OrderComplaintVO getOrderComplainById(String id) {
        return null;
    }

    @Override
    public OrderComplaint getOrderComplainByStoreId(String storeId) {
        return null;
    }

    @Override
    public OrderComplaint addOrderComplain(OrderComplaintDTO orderComplaintDTO) {
        return null;
    }

    @Override
    public boolean updateOrderComplain(OrderComplaintVO orderComplainVO) {
        return false;
    }

    @Override
    public OrderComplaint updateOrderComplainByStatus(OrderComplaintOperationParams operationParam) {
        return null;
    }

    @Override
    public long waitComplainNum() {
        return 0;
    }

    @Override
    public boolean cancel(String id) {
        return false;
    }

    @Override
    public boolean appeal(StoreAppealVO storeAppealVO) {
        return false;
    }
}
