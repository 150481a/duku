package org.duku.mall.framework.starter.common.modules.page.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageDataVO {
    @ApiModelProperty(value = "页面数据")
    private String pageData;
}
