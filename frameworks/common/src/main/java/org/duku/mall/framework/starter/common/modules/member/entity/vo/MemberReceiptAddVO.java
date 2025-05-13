package org.duku.mall.framework.starter.common.modules.member.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.member.entity.enums.MemberReceiptEnum;

@Data
public class MemberReceiptAddVO {
    private static final long serialVersionUID = -8267092982915677995L;

    @ApiModelProperty(value = "唯一标识", hidden = true)
    private String id;

    @ApiModelProperty(value = "发票抬头")
    private String receiptTitle;

    @ApiModelProperty(value = "纳税人识别号")
    private String taxpayerId;

    @ApiModelProperty(value = "发票内容")
    private String receiptContent;

    /**
     * @see MemberReceiptEnum
     */
    @ApiModelProperty(value = "发票类型")
    private String receiptType;

    @ApiModelProperty(value = "是否为默认选项 0：否，1：是")
    private Integer isDefault;
}
