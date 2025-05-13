package org.duku.mall.framework.starter.common.modules.order.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.order.aftersale.entity.dos.AfterSale;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.StoreFlow;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dto.StoreFlowQueryDTO;
import org.duku.mall.framework.starter.common.modules.order.order.mapper.StoreFlowMapper;
import org.duku.mall.framework.starter.common.modules.order.order.service.StoreFlowService;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.Bill;
import org.duku.mall.framework.starter.common.modules.store.entity.dto.StoreFlowPayDownloadVO;
import org.duku.mall.framework.starter.common.modules.store.entity.dto.StoreFlowRefundDownloadVO;
import org.duku.mall.framework.starter.common.modules.store.entity.params.BillSearchParams;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StoreFlowServiceImpl extends ServiceImpl<StoreFlowMapper, StoreFlow> implements StoreFlowService {
    @Override
    public void payOrder(String orderSn) {

    }

    @Override
    public void orderCancel(String orderSn) {

    }

    @Override
    public void refundOrder(AfterSale afterSale) {

    }

    @Override
    public IPage<StoreFlow> getStoreFlow(StoreFlowQueryDTO storeFlowQueryDTO) {
        return null;
    }

    @Override
    public StoreFlow queryOne(StoreFlowQueryDTO storeFlowQueryDTO) {
        return null;
    }

    @Override
    public List<StoreFlowPayDownloadVO> getStoreFlowPayDownloadVO(StoreFlowQueryDTO storeFlowQueryDTO) {
        return List.of();
    }

    @Override
    public List<StoreFlowRefundDownloadVO> getStoreFlowRefundDownloadVO(StoreFlowQueryDTO storeFlowQueryDTO) {
        return List.of();
    }

    @Override
    public IPage<StoreFlow> getStoreFlow(String id, String type, PageVO pageVO) {
        return null;
    }

    @Override
    public IPage<StoreFlow> getDistributionFlow(String id, PageVO pageVO) {
        return null;
    }

    @Override
    public List<StoreFlow> listStoreFlow(StoreFlowQueryDTO storeFlowQueryDTO) {
        return List.of();
    }

    @Override
    public void updateProfitSharingStatus() {

    }

    @Override
    public Bill getRefundBill(BillSearchParams searchParams) {
        return null;
    }

    @Override
    public Bill getOrderBill(BillSearchParams searchParams) {
        return null;
    }
}
