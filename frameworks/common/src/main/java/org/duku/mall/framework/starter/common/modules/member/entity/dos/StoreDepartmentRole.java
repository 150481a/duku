package org.duku.mall.framework.starter.common.modules.member.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_store_department_role")
@ApiModel(value = "店铺角色部门")
@NoArgsConstructor
@AllArgsConstructor
public class StoreDepartmentRole extends BaseEntity {

    private static final long serialVersionUID = 2342812932116647050L;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "部门id")
    private String departmentId;
}
