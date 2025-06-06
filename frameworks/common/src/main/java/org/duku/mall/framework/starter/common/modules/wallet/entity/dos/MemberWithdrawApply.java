package org.duku.mall.framework.starter.common.modules.wallet.entity.dos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.security.sensitive.Sensitive;
import org.duku.mall.framework.starter.common.common.security.sensitive.enums.SensitiveStrategy;
import org.duku.mall.framework.starter.common.modules.wallet.entity.enums.WithdrawStatusEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("li_member_withdraw_apply")
@ApiModel(value = "会员提现申请")
public class MemberWithdrawApply extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "申请提现金额")
    private Double applyMoney;

    /**
     * @see WithdrawStatusEnum
     */
    @ApiModelProperty(value = "提现状态")
    private String applyStatus;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员名称")
    @Sensitive(strategy = SensitiveStrategy.PHONE)
    private String memberName;

    @ApiModelProperty(value = "审核备注")
    private String inspectRemark;

    @ApiModelProperty(value = "审核时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date inspectTime;

    @ApiModelProperty(value = "sn")
    private String sn;

    /**
     * 支付宝提现时必填
     */
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    /**
     * 支付宝登录账号
     */
    @ApiModelProperty(value = "第三方平台账号")
    private String connectNumber;

    /**
     * 支付宝登录账号
     */
    @ApiModelProperty(value = "第三方错误消息")
    private String errorMessage;
}
