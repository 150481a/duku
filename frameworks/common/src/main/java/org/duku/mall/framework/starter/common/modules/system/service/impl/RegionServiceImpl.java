package org.duku.mall.framework.starter.common.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Region;
import org.duku.mall.framework.starter.common.modules.system.mapper.RegionMapper;
import org.duku.mall.framework.starter.common.modules.system.service.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
}
