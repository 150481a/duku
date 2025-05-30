package org.duku.mall.framework.starter.common.modules.distribution.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.distribution.entity.dto.DistributionApplyDTO;
import org.duku.mall.framework.starter.common.modules.distribution.entity.enums.DistributionStatusEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.hibernate.validator.constraints.Length;
import org.duku.mall.framework.starter.common.common.utils.BeanUtil;

@Data
@ApiModel(value = "分销员")
@TableName("li_distribution")
@NoArgsConstructor
public class Distribution extends BaseEntity {


    private static final long serialVersionUID = -4878132663540847325L;

    public Distribution(String memberId, String memberName, DistributionApplyDTO distributionApplyDTO) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.distributionOrderCount=0;
        this.rebateTotal=0D;
        this.canRebate=0D;
        this.commissionFrozen=0D;
        this.distributionOrderPrice=0D;
        this.distributionStatus = DistributionStatusEnum.APPLY.name();
        BeanUtil.copyProperties(distributionApplyDTO, this);
    }

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "会员姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    @ApiModelProperty(value = "分销总额")
    private Double rebateTotal = 0D;

    @ApiModelProperty(value = "可提现金额")
    private Double canRebate = 0D;

    @ApiModelProperty(value = "冻结金额")
    private Double commissionFrozen = 0D;

    @ApiModelProperty(value = "分销订单数")
    private Integer distributionOrderCount;

    /**
     * @see DistributionStatusEnum
     */
    @ApiModelProperty(value = "分销员状态", required = true)
    private String distributionStatus;

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

    @ApiModelProperty(value = "分销订单金额")
    private Double distributionOrderPrice;
}
