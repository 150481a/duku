package org.duku.mall.framework.starter.common.modules.wallet.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferResultDTO {

    @ApiModelProperty(value = "错误信息")
    private String response;
    @ApiModelProperty(value = "是否成功")
    private Boolean result;
}
