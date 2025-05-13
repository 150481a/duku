package org.duku.mall.framework.starter.common.modules.member.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
@Data
@TableName("li_store_menu_role")
@ApiModel(value = "店铺角色权限")
public class StoreMenuRole extends BaseEntity {

    private static final long serialVersionUID = -4680260092546996026L;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "菜单")
    private String menuId;

    @ApiModelProperty(value = "店铺id")
    private String storeId;

    @ApiModelProperty(value = "是否拥有操作数据权限，为否则只有查看权限")
    private Boolean isSuper;
}
