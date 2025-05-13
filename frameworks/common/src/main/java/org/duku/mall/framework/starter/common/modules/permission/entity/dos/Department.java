package org.duku.mall.framework.starter.common.modules.permission.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_department")
@ApiModel(value = "部门")
@EqualsAndHashCode(callSuper = true)
public class Department extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门名称")
    @NotNull(message = "部门名称不能为空")
    private String title;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private Double sortOrder;
}
