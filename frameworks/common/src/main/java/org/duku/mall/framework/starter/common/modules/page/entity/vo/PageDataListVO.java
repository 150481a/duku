package org.duku.mall.framework.starter.common.modules.page.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.convention.enums.SwitchEnum;

@Data
public class PageDataListVO {
    @ApiModelProperty(value = "页面ID")
    private String id;
    @ApiModelProperty(value = "页面名称")
    private String name;
    /**
     * @see SwitchEnum
     */
    @ApiModelProperty(value = "页面开关状态", allowableValues = "OPEN,CLOSE")
    private String pageShow;
}
