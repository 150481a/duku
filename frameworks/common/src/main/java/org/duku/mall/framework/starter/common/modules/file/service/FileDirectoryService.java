package org.duku.mall.framework.starter.common.modules.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.duku.mall.framework.starter.common.modules.file.entity.dos.FileDirectory;
import org.duku.mall.framework.starter.common.modules.file.entity.dto.FileDirectoryDTO;

import java.util.List;

public interface FileDirectoryService extends IService<FileDirectory> {
    /**
     * 添加目录
     *
     * @param userEnum
     * @param id
     * @param ownerName
     */
    void addFileDirectory(UserEnums userEnum, String id, String ownerName);

    /**
     * 获取文件目录
     *
     * @param ownerId 拥有者
     * @return
     */
    List<FileDirectoryDTO> getFileDirectoryList(String ownerId);
}
