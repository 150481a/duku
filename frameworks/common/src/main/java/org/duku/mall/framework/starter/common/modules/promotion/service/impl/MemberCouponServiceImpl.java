package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.MemberCoupon;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.MemberCouponMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.MemberCouponService;
import org.springframework.stereotype.Service;

@Service
public class MemberCouponServiceImpl extends ServiceImpl <MemberCouponMapper, MemberCoupon> implements MemberCouponService {
}
