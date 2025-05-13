package org.duku.mall.framework.starter.common.modules.file.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
import org.duku.mall.framework.starter.common.modules.file.entity.dos.FileDirectory;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class FileDirectoryDTO extends FileDirectory {

    @ApiModelProperty(value = "文件目录列表")
    private List<FileDirectory> children= new ArrayList<>();

    public FileDirectoryDTO(FileDirectory fileDirectory){
        BeanUtil.copyProperties(fileDirectory, this);
    }
}
