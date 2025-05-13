package org.duku.mall.framework.starter.common.modules.store.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StoreFlowRefundDownloadVO extends StoreFlowPayDownloadVO{
    @ApiModelProperty(value = "售后SN")
    private String refundSn;
}
