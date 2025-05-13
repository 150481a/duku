package org.duku.mall.framework.starter.common.modules.wallet.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.wallet.entity.enums.DepositServiceTypeEnum;

@Data
@AllArgsConstructor
public class MemberWalletUpdateDTO {

    @ApiModelProperty(value = "变动金额")
    private Double money;
    @ApiModelProperty(value = "变动会员id")
    private String memberId;
    @ApiModelProperty(value = "日志详情")
    private String detail;

    /**
     * @see DepositServiceTypeEnum
     */
    @ApiModelProperty(value = "变动业务原因")
    private String serviceType;
}
