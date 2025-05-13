package org.duku.mall.framework.starter.common.modules.order.order.entity.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderComplaintOperationParams {


    @ApiModelProperty(value = "要更改的状态状态")
    private String complainStatus;

    @ApiModelProperty("交易投诉主键")
    private String complainId;

    @ApiModelProperty("商家申诉内容")
    private String appealContent;

    @ApiModelProperty("商家申诉上传的图片")
    private List<String> images;

    @ApiModelProperty("仲裁结果")
    private String arbitrationResult;

}
