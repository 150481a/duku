package org.duku.mall.framework.starter.common.modules.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.duku.mall.framework.starter.common.modules.file.entity.dos.FileDirectory;
import org.duku.mall.framework.starter.common.modules.file.entity.dto.FileDirectoryDTO;
import org.duku.mall.framework.starter.common.modules.file.mapper.FileDirectoryMapper;
import org.duku.mall.framework.starter.common.modules.file.service.FileDirectoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileDirectoryServiceImpl extends ServiceImpl<FileDirectoryMapper, FileDirectory> implements FileDirectoryService {
    @Override
    public void addFileDirectory(UserEnums userEnum, String id, String ownerName) {

    }

    @Override
    public List<FileDirectoryDTO> getFileDirectoryList(String ownerId) {
        return List.of();
    }
}
