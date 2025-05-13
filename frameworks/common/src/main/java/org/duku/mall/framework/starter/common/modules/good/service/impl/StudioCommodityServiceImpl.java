package org.duku.mall.framework.starter.common.modules.good.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.good.entity.dos.StudioCommodity;
import org.duku.mall.framework.starter.common.modules.good.mapper.StudioCommodityMapper;
import org.duku.mall.framework.starter.common.modules.good.service.StudioCommodityService;
import org.springframework.stereotype.Service;

@Service
public class StudioCommodityServiceImpl extends ServiceImpl <StudioCommodityMapper, StudioCommodity> implements StudioCommodityService {
}
