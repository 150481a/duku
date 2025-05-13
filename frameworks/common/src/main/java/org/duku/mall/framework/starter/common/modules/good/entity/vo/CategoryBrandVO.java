package org.duku.mall.framework.starter.common.modules.good.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CategoryBrandVO {
    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id", required = true)
    private String id;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称", required = true)
    private String name;
}
