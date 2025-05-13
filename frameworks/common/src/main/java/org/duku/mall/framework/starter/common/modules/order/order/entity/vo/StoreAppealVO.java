package org.duku.mall.framework.starter.common.modules.order.order.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreAppealVO {
    @ApiModelProperty(value = "投诉id")
    private String orderComplaintId;

    @ApiModelProperty(value = "申诉商家内容")
    private String appealContent;

    @ApiModelProperty(value = "申诉商家上传的图片")
    private String appealImages;
}
