package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.CouponActivity;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.CouponActivityMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.CouponActivityService;
import org.springframework.stereotype.Service;

@Service
public class CouponActivityServiceImpl extends ServiceImpl <CouponActivityMapper, CouponActivity> implements CouponActivityService {
}
