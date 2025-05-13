package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;
import org.duku.mall.framework.starter.common.modules.member.entity.dos.MemberReceipt;
import org.duku.mall.framework.starter.common.modules.member.entity.enums.MemberReceiptEnum;

@Data
@ApiModel(value = "会员发票")
public class MemberReceiptVO {

    private static final long serialVersionUID = -8210927982915677995L;

    @ApiModelProperty(value = "会员ID")
    private String memberId;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    /**
     * @see MemberReceiptEnum
     */
    @ApiModelProperty(value = "发票类型")
    private String receiptType;

    public LambdaQueryWrapper<MemberReceipt> lambdaQueryWrapper() {
        LambdaQueryWrapper<MemberReceipt> queryWrapper = new LambdaQueryWrapper<>();

        //会员名称查询
        if (StringUtils.isNotEmpty(memberName)) {
            queryWrapper.like(MemberReceipt::getMemberName, memberName);
        }
        //会员id查询
        if (StringUtils.isNotEmpty(memberId)) {
            queryWrapper.eq(MemberReceipt::getMemberId, memberId);
        }
        //会员id查询
        if (StringUtils.isNotEmpty(receiptType)) {
            queryWrapper.eq(MemberReceipt::getReceiptType, receiptType);
        }
        queryWrapper.eq(MemberReceipt::getDeleteFlag, true);
        queryWrapper.orderByDesc(MemberReceipt::getCreateTime);
        return queryWrapper;
    }
}
