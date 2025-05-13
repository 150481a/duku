package org.duku.mall.framework.starter.common.modules.member.entity.dos;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;

@Data
@TableName("li_clerk_role")
@ApiModel(value = "用户角色")
@Builder
@NoArgsConstructor
public class StoreClerkRole extends BaseIdEntity {

    @ApiModelProperty(value = "店员唯一id")
    private String clerkId;

    @ApiModelProperty(value = "角色唯一id")
    private String roleId;

    public StoreClerkRole(String clerkId, String roleId) {
        this.clerkId = clerkId;
        this.roleId = roleId;
    }
}
