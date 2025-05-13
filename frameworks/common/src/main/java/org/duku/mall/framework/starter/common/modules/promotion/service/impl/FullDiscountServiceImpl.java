package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.FullDiscount;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.FullDiscountMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.FullDiscountService;
import org.springframework.stereotype.Service;

@Service
public class FullDiscountServiceImpl extends ServiceImpl<FullDiscountMapper, FullDiscount> implements FullDiscountService {
}
