package org.duku.mall.framework.starter.common.modules.file.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.duku.mall.framework.starter.common.modules.file.entity.dos.File;
import org.duku.mall.framework.starter.common.modules.file.entity.dto.FileOwnerDTO;
import org.duku.mall.framework.starter.user.core.UserInfoDTO;

import java.util.List;

public interface FileService extends IService<File> {


    /**
     * 批量删除
     *
     * @param ids
     */
    void batchDelete(List<String> ids);
    /**
     * 根据文件夹ID批量删除
     *
     * @param directoryId 文件夹ID
     */
    void batchDeleteByDirectory(String directoryId);

    /**
     * 根据文件夹ID查看是否有文件
     * @param directoryId 文件夹ID
     * @return
     */
    Boolean countByDirectory(String directoryId);

    /**
     * 所有者批量删除
     *
     * @param ids      ID
     * @param authUser 操作者
     */
    void batchDelete(List<String> ids, UserInfoDTO authUser);


    /**
     * 自定义搜索分页
     *

     * @param fileOwnerDTO 文件查询

     * @return
     */
    IPage<File> customerPage(FileOwnerDTO fileOwnerDTO);

    /**
     * 所属文件数据查询
     *
     * @param ownerDTO 文件查询
     * @return
     */
    IPage<File> customerPageOwner(FileOwnerDTO ownerDTO);
}
