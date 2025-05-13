package org.duku.mall.framework.starter.common.modules.permission.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;

@Data
@TableName("li_user_role")
@ApiModel(value = "用户角色")
public class UserRole extends BaseIdEntity {
    @ApiModelProperty(value = "用户唯一id")
    private String userId;

    @ApiModelProperty(value = "角色唯一id")
    private String roleId;

    public UserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRole() {

    }
}
