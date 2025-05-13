package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.Clerk;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreMenu;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.StoreRole;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClerkVO extends Clerk {
    private static final long serialVersionUID = -2378384199695839312L;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "所属部门名称")
    private String departmentTitle;

    @ApiModelProperty(value = "用户拥有角色")
    private List<StoreRole> roles;

    @ApiModelProperty(value = "用户拥有的权限")
    private List<StoreMenu> menus;


    public ClerkVO(Clerk clerk) {
        BeanUtil.copyProperties(clerk, this);
    }
}
