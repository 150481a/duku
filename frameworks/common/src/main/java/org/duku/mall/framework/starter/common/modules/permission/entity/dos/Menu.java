package org.duku.mall.framework.starter.common.modules.permission.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_menu")
@ApiModel(value = "菜单权限")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 7050744476203495207L;


    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "路由名称")
    private String name;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "菜单层级")
    private Integer level;

    @ApiModelProperty(value = "前端目录文件")
    private String frontRoute;

    @ApiModelProperty(value = "父id")
    private String parentId = "0";

    @ApiModelProperty(value = "排序值")
    private Double sortOrder;

    @ApiModelProperty(value = "权限URL，*号模糊匹配，逗号分割")
    private String permission;
}
