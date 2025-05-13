package org.duku.mall.framework.starter.common.modules.logistics.service;

import cn.hutool.json.JSONUtil;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.common.modules.logistics.entity.enums.LogisticsEnum;
import org.duku.mall.framework.starter.common.modules.logistics.service.plugin.kdniao.KdniaoPlugin;
import org.duku.mall.framework.starter.common.modules.logistics.service.plugin.kuaidi100.Kuaidi100Plugin;
import org.duku.mall.framework.starter.common.modules.logistics.service.plugin.shunfeng.ShunfengPlugin;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.LogisticsSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Setting;
import org.duku.mall.framework.starter.common.modules.system.entity.enums.SettingEnum;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogisticsPluginFactory {


    @Autowired
    private SettingService settingService;


    /**
     * 获取logistics client
     *
     * @return
     */
    public LogisticsPlugin filePlugin() {

        LogisticsSetting logisticsSetting = null;
        try {
            Setting setting = settingService.get(SettingEnum.LOGISTICS_SETTING.name());
            logisticsSetting = JSONUtil.toBean(setting.getSettingValue(), LogisticsSetting.class);
            switch (LogisticsEnum.valueOf(logisticsSetting.getType())) {
                case KDNIAO:
                    return new KdniaoPlugin(logisticsSetting);
                case KUAIDI100:
                    return new Kuaidi100Plugin(logisticsSetting);
                case SHUNFENG:
                    return new ShunfengPlugin(logisticsSetting);
                default:
                    throw new ServiceException("未找到对应的物流插件");
            }
        } catch (Exception e) {
            throw new ServiceException("获取物流插件失败");
        }
    }
}
