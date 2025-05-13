package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.BasePromotions;
import org.duku.mall.framework.starter.common.modules.promotion.service.AbstractPromotionsService;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractPromotionsServiceImpl<M extends BaseMapper<T>, T extends BasePromotions> extends ServiceImpl<M, T> implements AbstractPromotionsService<T> {
}
