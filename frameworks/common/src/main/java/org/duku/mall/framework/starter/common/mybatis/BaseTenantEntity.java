package org.duku.mall.framework.starter.common.mybatis;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 租户超级类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  abstract class BaseTenantEntity extends BaseEntity {
    @ApiModelProperty(value = "租户id", hidden = true)
    private String tenantId;
}
