package org.duku.mall.framework.starter.common.modules.permission.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.AdminUser;
import org.duku.mall.framework.starter.common.modules.permission.entity.dos.Role;

import java.awt.*;
import java.util.List;
@Data
public class AdminUserVO extends AdminUser {
    private static final long serialVersionUID = -2378384199695839312L;

    @ApiModelProperty(value = "所属部门名称")
    private String departmentTitle;

    @ApiModelProperty(value = "用户拥有角色")
    private List<Role> roles;

    @ApiModelProperty(value = "用户拥有的权限")
    private List<Menu> menus;


    public AdminUserVO(AdminUser user) {
        BeanUtil.copyProperties(user, this);
    }
}
