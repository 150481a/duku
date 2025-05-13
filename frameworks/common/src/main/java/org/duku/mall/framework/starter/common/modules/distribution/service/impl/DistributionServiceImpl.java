package org.duku.mall.framework.starter.common.modules.distribution.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.vo.PageVO;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dos.Distribution;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dto.DistributionApplyDTO;
import org.duku.mall.framework.starter.common.modules.distribution.entity.params.DistributionSearchParams;
import org.duku.mall.framework.starter.common.modules.distribution.mapper.DistributionMapper;
import org.duku.mall.framework.starter.common.modules.distribution.service.DistributionService;
import org.duku.mall.framework.starter.common.modules.member.service.MemberService;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DistributionServiceImpl extends ServiceImpl<DistributionMapper, Distribution> implements DistributionService {

    /**
     * 会员
     */
    @Autowired
    private MemberService memberService;
    /**
     * 缓存
     */
    @Autowired
    private SingletonCache cache;
    /**
     * 设置
     */
    @Autowired
    private SettingService settingService;

    @Override
    public IPage<Distribution> distributionPage(DistributionSearchParams distributionSearchParams, PageVO page) {
        return null;
    }

    @Override
    public Distribution getDistribution() {
        return null;
    }

    @Override
    public Distribution applyDistribution(DistributionApplyDTO distributionApplyDTO) {
        return null;
    }

    @Override
    public boolean audit(String id, String status) {
        return false;
    }

    @Override
    public boolean retreat(String id) {
        return false;
    }

    @Override
    public boolean resume(String id) {
        return false;
    }

    @Override
    public void bindingDistribution(String distributionId) {

    }

    @Override
    public void checkDistributionSetting() {

    }

    @Override
    public void addRebate(Double rebate, String distributionId, Double distributionOrderPrice) {

    }

    @Override
    public void subRebate(Double rebate, String distributionId, Double distributionOrderPrice) {

    }

    @Override
    public void addCanRebate(Double rebate, String distributionId) {

    }

    @Override
    public void addCashRebate(Double rebate, String distributionId) {

    }

    @Override
    public void subCashRebate(Double rebate, String distributionId) {

    }
}
