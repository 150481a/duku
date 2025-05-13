package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.MemberCouponSign;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.MemberCouponSignMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.MemberCouponSignService;
import org.springframework.stereotype.Service;

@Service
public class MemberCouponSignServiceImpl extends ServiceImpl <MemberCouponSignMapper, MemberCouponSign> implements MemberCouponSignService {
}
