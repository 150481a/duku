package org.duku.mall.framework.starter.common.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Setting;
import org.duku.mall.framework.starter.common.modules.system.mapper.SettingMapper;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements SettingService {
    @Override
    public Setting get(String key) {
        return this.getById(key);
    }

    @Override
    public boolean saveUpdate(Setting setting) {
        return this.saveOrUpdate(setting);
    }
}
