package org.duku.mall.framework.starter.common.modules.file.plugin;

import org.duku.mall.framework.starter.common.modules.file.entity.enums.OssEnum;

import java.io.InputStream;
import java.util.List;

public interface FilePlugin {


    /**
     * 插件名称
     */
    OssEnum pluginName();

    /**
     * 文件路径上传
     *
     * @param filePath
     * @param key
     * @return
     */
    String pathUpload(String filePath, String key);

    /**
     * 文件流上传
     *
     * @param inputStream
     * @param key
     * @return
     */
    String inputStreamUpload(InputStream inputStream, String key);


    /**
     * 删除文件
     *
     * @param key
     */
    void deleteFile(List<String> key);
}
