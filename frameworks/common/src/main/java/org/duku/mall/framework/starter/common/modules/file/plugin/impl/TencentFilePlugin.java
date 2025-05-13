package org.duku.mall.framework.starter.common.modules.file.plugin.impl;

import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.file.entity.enums.OssEnum;
import org.duku.mall.framework.starter.common.modules.file.plugin.FilePlugin;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.OssSetting;

import java.io.InputStream;
import java.util.List;

@Slf4j
public class TencentFilePlugin implements FilePlugin {

    private OssSetting ossSetting;
    @Override
    public OssEnum pluginName() {
        return null;
    }

    @Override
    public String pathUpload(String filePath, String key) {
        return "";
    }

    @Override
    public String inputStreamUpload(InputStream inputStream, String key) {
        return "";
    }

    @Override
    public void deleteFile(List<String> key) {

    }
}
