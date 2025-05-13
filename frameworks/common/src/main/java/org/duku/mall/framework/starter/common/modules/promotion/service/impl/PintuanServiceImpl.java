package org.duku.mall.framework.starter.common.modules.promotion.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.promotion.entity.dos.Pintuan;
import org.duku.mall.framework.starter.common.modules.promotion.mapper.PintuanMapper;
import org.duku.mall.framework.starter.common.modules.promotion.service.PintuanService;
import org.springframework.stereotype.Service;

@Service
public class PintuanServiceImpl extends ServiceImpl <PintuanMapper, Pintuan> implements PintuanService {
}
