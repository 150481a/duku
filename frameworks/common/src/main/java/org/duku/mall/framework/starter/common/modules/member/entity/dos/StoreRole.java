package org.duku.mall.framework.starter.common.modules.member.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_store_role")
@ApiModel(value = "店铺角色")
public class StoreRole extends BaseEntity {


    @ApiModelProperty(value = "角色名")
    @NotEmpty(message = "角色名称必填")
    private String name;

    @ApiModelProperty(value = "店铺id", hidden = true)
    private String storeId;

    @ApiModelProperty(value = "是否为注册默认角色")
    private Boolean defaultRole = false;

    @ApiModelProperty(value = "备注")
    private String description;
}
