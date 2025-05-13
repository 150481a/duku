package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Coupon;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.CouponMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.CouponService;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
}
