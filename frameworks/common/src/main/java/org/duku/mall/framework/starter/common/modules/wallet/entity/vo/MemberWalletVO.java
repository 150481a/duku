package org.duku.mall.framework.starter.common.modules.wallet.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "会员预存款")
@NoArgsConstructor
@AllArgsConstructor
public class MemberWalletVO {
    @ApiModelProperty(value = "会员预存款")
    private Double memberWallet;

    @ApiModelProperty(value = "会员预存款冻结金额,提现使用")
    private Double memberFrozenWallet;
}
