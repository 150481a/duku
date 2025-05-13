package org.duku.mall.framework.starter.common.modules.im.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseTenantEntity;

@Data
@TableName("li_seat")
@ApiModel(value = "坐席")
@NoArgsConstructor
public class Seat extends BaseTenantEntity {

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "坐席用户名")
    private String username;

    @ApiModelProperty(value = "会员头像")
    private String face;

    @ApiModelProperty(value = "坐席密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "坐席状态")
    private Boolean disabled;

    @NotEmpty(message = "手机号码不能为空")
    @ApiModelProperty(value = "手机号码", required = true)
    private String mobile;
}
