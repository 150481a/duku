package org.duku.mall.framework.starter.common.modules.member.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_store_department")
@ApiModel(value = "店铺部门")
public class StoreDepartment extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "店铺id", hidden = true)
    private String storeId;

    @ApiModelProperty(value = "部门名称")
    @NotEmpty(message = "部门名称不能为空")
    private String title;

    @ApiModelProperty(value = "父id")
    @NotEmpty(message = "父id不能为空")
    private String parentId;

    @ApiModelProperty(value = "排序值")
    private Double sortOrder;
}
