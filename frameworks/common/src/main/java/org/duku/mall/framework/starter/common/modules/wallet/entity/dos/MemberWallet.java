package org.duku.mall.framework.starter.common.modules.wallet.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_member_wallet")
@ApiModel(value = "会员预存款")
public class MemberWallet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员用户名")
    private String memberName;

    @ApiModelProperty(value = "会员ID")
    private String memberId;

    @ApiModelProperty(value = "会员预存款")
    private Double memberWallet;

    @ApiModelProperty(value = "会员预存款冻结金额,提现使用")
    private Double memberFrozenWallet;

    @ApiModelProperty(value = "预存款密码")
    private String walletPassword;
}
