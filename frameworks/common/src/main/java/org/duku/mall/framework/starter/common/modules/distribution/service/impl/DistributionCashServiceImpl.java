package org.duku.mall.framework.starter.common.modules.distribution.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dos.DistributionCash;
import org.duku.mall.framework.starter.common.modules.distribution.entity.params.DistributionCashSearchParams;
import org.duku.mall.framework.starter.common.modules.distribution.mapper.DistributionCashMapper;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionCashService;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionService;
import org.duku.mall.framework.starter.common.modules.wallet.service.MemberWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistributionCashServiceImpl extends ServiceImpl<DistributionCashMapper, DistributionCash> implements DistributionCashService {

    /**
     * 分销员
     */
    @Autowired
    private DistributionService distributionService;
    /**
     * 会员余额
     */
    @Autowired
    private MemberWalletService memberWalletService;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;

    @Override
    public Boolean cash(Double applyMoney) {
        return null;
    }

    @Override
    public IPage<DistributionCash> getDistributionCash(PageVO page) {
        return null;
    }

    @Override
    public IPage<DistributionCash> getDistributionCash(DistributionCashSearchParams distributionCashSearchParams) {
        return null;
    }

    @Override
    public void queryExport(HttpServletResponse response, DistributionCashSearchParams distributionCashSearchParams) {

    }

    @Override
    public DistributionCash audit(String id, String result) {
        return null;
    }
}
