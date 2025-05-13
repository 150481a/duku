package org.duku.mall.framework.starter.common.modules.distribution.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class DistributionApplyDTO {
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "会员姓名")
    private String name;

    @NotBlank(message = "身份证号不能为空")
    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @Length(min = 1, max = 200, message = "结算银行开户行名称长度为1-200位")
    @NotBlank(message = "结算银行开户行名称不能为空")
    @ApiModelProperty(value = "结算银行开户行名称")
    private String settlementBankAccountName;

    @Length(min = 1, max = 200, message = "结算银行开户账号长度为1-200位")
    @NotBlank(message = "结算银行开户账号不能为空")
    @ApiModelProperty(value = "结算银行开户账号")
    private String settlementBankAccountNum;

    @Length(min = 1, max = 200, message = "结算银行开户支行名称长度为1-200位")
    @NotBlank(message = "结算银行开户支行名称不能为空")
    @ApiModelProperty(value = "结算银行开户支行名称")
    private String settlementBankBranchName;
}
