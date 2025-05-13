package org.duku.mall.framework.starter.common.modules.member.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

import java.util.List;

@Data
public class ClerkEditDTO extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店员id", hidden = true)
    private String id;

    @ApiModelProperty(value = "会员密码")
    private String password;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "所属部门id")
    private String departmentId;

    @ApiModelProperty(value = "是否是超级管理员 超级管理员/普通管理员")
    private Boolean isSuper = false;

    @ApiModelProperty(value = "角色")
    private List<String> roles;
}
