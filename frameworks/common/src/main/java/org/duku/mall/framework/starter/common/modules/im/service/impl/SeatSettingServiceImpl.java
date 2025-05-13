package org.duku.mall.framework.starter.common.modules.im.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.im.entity.dos.SeatSetting;
import org.duku.mall.framework.starter.common.modules.im.mapper.SeatSettingMapper;
import org.duku.mall.framework.starter.common.modules.im.service.SeatSettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SeatSettingServiceImpl extends ServiceImpl<SeatSettingMapper, SeatSetting> implements SeatSettingService {
    @Override
    public SeatSetting getSetting(String storeId) {
        return null;
    }

    @Override
    public SeatSetting updateByStore(SeatSetting seatSetting) {
        return null;
    }
}
