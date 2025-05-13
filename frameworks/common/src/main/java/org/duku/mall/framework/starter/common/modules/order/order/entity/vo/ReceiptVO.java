package org.duku.mall.framework.starter.common.modules.order.order.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "发票")
public class ReceiptVO implements Serializable {
    private static final long serialVersionUID = -8402457457074092957L;

    @ApiModelProperty(value = "发票抬头")
    private String receiptTitle;

    @ApiModelProperty(value = "纳税人识别号")
    private String taxpayerId;

    @ApiModelProperty(value = "发票内容")
    private String receiptContent;
}
