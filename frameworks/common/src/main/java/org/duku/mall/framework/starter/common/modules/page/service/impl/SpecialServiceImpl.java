package org.duku.mall.framework.starter.common.modules.page.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.page.entity.dos.Special;
import org.duku.mall.framework.starter.common.modules.page.mapper.SpecialMapper;
import org.duku.mall.framework.starter.common.modules.page.service.SpecialService;
import org.springframework.stereotype.Service;

@Service
public class SpecialServiceImpl extends ServiceImpl<SpecialMapper, Special> implements SpecialService {
    @Override
    public Special addSpecial(Special special) {
        return null;
    }

    @Override
    public boolean removeSpecial(String id) {
        return false;
    }
}
