package org.duku.mall.framework.starter.common.modules.permission.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_department_role")
@ApiModel(value = "角色部门")
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRole extends BaseEntity {

    private static final long serialVersionUID = 2342812932116647050L;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "部门id")
    private String departmentId;
}
