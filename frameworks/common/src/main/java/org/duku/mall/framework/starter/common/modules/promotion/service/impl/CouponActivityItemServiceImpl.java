package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.CouponActivityItem;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.CouponActivityItemMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.CouponActivityItemService;
import org.springframework.stereotype.Service;

@Service
public class CouponActivityItemServiceImpl extends ServiceImpl<CouponActivityItemMapper, CouponActivityItem> implements CouponActivityItemService {
}
