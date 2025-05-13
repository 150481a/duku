package org.duku.mall.framework.starter.common.modules.file.plugin;

import cn.hutool.json.JSONUtil;
import org.duku.mall.framework.starter.common.modules.file.entity.enums.OssEnum;
import org.duku.mall.framework.starter.common.modules.system.entity.dos.Setting;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.OssSetting;
import org.duku.mall.framework.starter.common.modules.system.entity.enums.SettingEnum;
import org.duku.mall.framework.starter.common.modules.system.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilePluginFactory {


    @Autowired
    private SettingService settingService;


    /**
     * 获取oss client
     *
     * @return
     */
    public FilePlugin filePlugin() {

        OssSetting ossSetting = null;
        try {
            Setting setting = settingService.get(SettingEnum.OSS_SETTING.name());

            ossSetting = JSONUtil.toBean(setting.getSettingValue(), OssSetting.class);


            switch (OssEnum.valueOf(ossSetting.getType())) {

                case MINIO:
                    return new MinioFilePlugin(ossSetting);
                case ALI_OSS:
                    return new AliFilePlugin(ossSetting);
                case HUAWEI_OBS:
                    return new HuaweiFilePlugin(ossSetting);
                case TENCENT_COS:
                    return new TencentFilePlugin(ossSetting);
                default:
                    throw new ServiceException();
            }
        } catch (Exception e) {
            throw new ServiceException();
        }
    }
}
