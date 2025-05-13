package org.duku.mall.framework.starter.common.modules.page.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.page.entity.enums.PageEnum;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;

@Data
@NoArgsConstructor
public class PageDataDTO {

    @ApiModelProperty(value = "值")
    private String num;

    /**
     * @see PageEnum
     */
    @ApiModelProperty(value = "页面类型", allowableValues = "INDEX,STORE,SPECIAL")
    private String pageType;

    /**
     * @see ClientTypeEnum
     */
    @ApiModelProperty(value = "客户端类型", allowableValues = "PC,H5,WECHAT_MP,APP")
    private String pageClientType;

    public PageDataDTO(String pageType) {
        this.pageType = pageType;
    }
}
