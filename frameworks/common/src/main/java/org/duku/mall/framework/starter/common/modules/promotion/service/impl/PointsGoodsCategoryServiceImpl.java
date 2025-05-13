package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.PointsGoodsCategory;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.PointsGoodsCategoryMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.PointsGoodsCategoryService;
import org.springframework.stereotype.Service;

@Service
public class PointsGoodsCategoryServiceImpl extends ServiceImpl <PointsGoodsCategoryMapper, PointsGoodsCategory>  implements PointsGoodsCategoryService {
}
