package org.duku.mall.framework.starter.common.modules.file.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.common.modules.file.entity.dto.FileOwnerDTO;
import org.duku.mall.framework.starter.common.modules.file.mapper.FileMapper;
import org.duku.mall.framework.starter.common.modules.file.service.FileService;
import org.duku.mall.framework.starter.common.modules.file.entity.dos.File;
import org.duku.mall.framework.starter.user.core.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Autowired
    private FilePluginFactory filePluginFactory;

    @Override
    public void batchDelete(List<String> ids) {

    }

    @Override
    public void batchDeleteByDirectory(String directoryId) {

    }

    @Override
    public Boolean countByDirectory(String directoryId) {
        return null;
    }

    @Override
    public void batchDelete(List<String> ids, UserInfoDTO authUser) {

    }

    @Override
    public IPage<File> customerPage(FileOwnerDTO fileOwnerDTO) {
        return null;
    }

    @Override
    public IPage<File> customerPageOwner(FileOwnerDTO ownerDTO) {
        return null;
    }
}
