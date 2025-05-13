package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.PointsGoods;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.PointsGoodsMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.PointsGoodsService;
import org.springframework.stereotype.Service;

@Service
public class PointsGoodsServiceImpl extends ServiceImpl<PointsGoodsMapper, PointsGoods> implements PointsGoodsService {
}
