package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StoreCollectionVO {
    @ApiModelProperty(value = "店铺id")
    private String id;

    @ApiModelProperty(value = "店铺名称")
    private String storeName;

    @ApiModelProperty(value = "店铺Logo")
    private String storeLogo;

    @ApiModelProperty(value = "是否自营")
    private Boolean selfOperated;
}
