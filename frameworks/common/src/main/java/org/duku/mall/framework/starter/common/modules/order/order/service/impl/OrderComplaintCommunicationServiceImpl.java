package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderComplaintCommunication;
import org.duku.mall.framework.starter.common.modules.order.order.entity.params.OrderComplaintCommunicationSearchParams;
import org.duku.mall.framework.starter.common.modules.order.order.entity.vo.OrderComplaintCommunicationVO;
import org.duku.mall.framework.starter.common.modules.order.order.mapper.OrderComplaintCommunicationMapper;
import org.duku.mall.framework.starter.common.modules.order.order.service.OrderComplaintCommunicationService;
import org.springframework.stereotype.Service;

@Service
public class OrderComplaintCommunicationServiceImpl extends ServiceImpl <OrderComplaintCommunicationMapper, OrderComplaintCommunication>  implements OrderComplaintCommunicationService {
    @Override
    public boolean addCommunication(OrderComplaintCommunicationVO communicationVO) {
        return false;
    }

    @Override
    public IPage<OrderComplaintCommunication> getCommunication(OrderComplaintCommunicationSearchParams searchParams, PageVO pageVO) {
        return null;
    }
}
