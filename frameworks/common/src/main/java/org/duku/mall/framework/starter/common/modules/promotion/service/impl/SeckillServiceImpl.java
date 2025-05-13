package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.duku.mall.framework.starter.common.common.properties.RocketmqCustomProperties;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Seckill;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.SeckillApply;
import org.duku.mall.framework.starter.common.modules.promotion.entity.vos.SeckillVO;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.SeckillMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.SeckillApplyService;
import org.duku.mall.framework.starter.common.modules.promotion.service.SeckillService;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillServiceImpl extends AbstractPromotionsServiceImpl<SeckillMapper, Seckill> implements SeckillService {

    /**
     * 设置
     */
    @Autowired
    private SettingService settingService;

    @Autowired
    private SeckillApplyService seckillApplyService;

    /**
     * rocketMq配置
     */
    @Autowired
    private RocketmqCustomProperties rocketmqCustomProperties;

    /**
     * rocketMq
     */
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public SeckillVO getSeckillDetail(String id) {
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public long getApplyNum() {
        return 0;
    }

    @Override
    public void updateSeckillGoodsNum(String seckillId) {

    }

    @Override
    public void updateEsGoodsSeckill(Seckill seckill, List<SeckillApply> seckillApplies) {

    }

    @Override
    public void deleteEsGoodsSeckill(Seckill seckill, List<String> skuIds) {

    }

    @Override
    public void setSeckillApplyTime(Seckill seckill, SeckillApply seckillApply) {

    }
}
