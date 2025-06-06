package org.duku.mall.framework.starter.common.modules.member.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.validation.Phone;

@Data
public class MemberAddressDTO {
    @NotEmpty(message = "收货人姓名不能为空")
    @ApiModelProperty(value = "收货人姓名")
    private String consigneeName;

    @Phone
    @ApiModelProperty(value = "手机号码")
    private String consigneeMobile;

    @NotBlank(message = "地址不能为空")
    @ApiModelProperty(value = "地址名称， '，'分割")
    private String consigneeAddressPath;

    @NotBlank(message = "地址不能为空")
    @ApiModelProperty(value = "地址id，'，'分割 ")
    private String consigneeAddressIdPath;

    @NotEmpty(message = "详细地址不能为空")
    @ApiModelProperty(value = "详细地址")
    private String consigneeDetail;
}
