package org.duku.mall.framework.starter.common.modules.member.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.member.entity.vo.StoreLogisticsVO;
import org.duku.mall.framework.starter.common.modules.member.mapper.StoreLogisticsMapper;
import org.duku.mall.framework.starter.common.modules.member.service.StoreLogisticsService;
import org.duku.mall.framework.starter.common.modules.store.entity.dos.StoreLogistics;
import org.duku.mall.framework.starter.common.modules.store.entity.dto.StoreLogisticsCustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreLogisticsServiceImpl extends ServiceImpl<StoreLogisticsMapper, StoreLogistics> implements StoreLogisticsService {
    @Override
    public List<StoreLogisticsVO> getStoreLogistics(String storeId) {
        return List.of();
    }

    @Override
    public List<StoreLogisticsVO> getStoreSelectedLogistics(String storeId) {
        return List.of();
    }

    @Override
    public List<String> getStoreSelectedLogisticsName(String storeId) {
        return List.of();
    }

    @Override
    public StoreLogistics add(String logisticsId, String storeId, StoreLogisticsCustomerDTO storeLogisticsCustomerDTO) {
        return null;
    }

    @Override
    public List<StoreLogisticsVO> getStoreSelectedLogisticsUseFaceSheet(String storeId) {
        return List.of();
    }

    @Override
    public StoreLogistics update(String logisticsId, String storeId, StoreLogisticsCustomerDTO storeLogisticsCustomerDTO) {
        return null;
    }

    @Override
    public StoreLogistics getStoreLogisticsInfo(String logisticsId) {
        return null;
    }

    @Override
    public List<StoreLogisticsVO> getOpenStoreLogistics(String storeId) {
        return List.of();
    }

    @Override
    public List<StoreLogisticsVO> getCloseStoreLogistics(String storeId) {
        return List.of();
    }
}
