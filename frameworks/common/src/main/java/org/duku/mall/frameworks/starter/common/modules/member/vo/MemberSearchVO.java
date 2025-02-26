package org.duku.mall.frameworks.starter.common.modules.member.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.convention.enums.SwitchEnum;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MemberSearchVO implements Serializable {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "用户手机号码")
    private String mobile;

    /**
     * @see SwitchEnum
     */
    @ApiModelProperty(value = "会员状态")
    private String disabled;

}
