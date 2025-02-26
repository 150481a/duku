package org.duku.mall.frameworks.starter.common.modules.member.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ManagerMemberEditDTO {

    @NotNull(message = "用户ID不能为空")
    private String id;

    @ApiModelProperty(value = "会员用户名,用户名不能进行修改", required = true)
    @NotNull(message = "会员用户名不能为空")
    private String username;

    @ApiModelProperty(value = "会员密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    @Length(min = 2, max = 20, message = "会员昵称必须为2到20位之间")
    private String nickName;

    @ApiModelProperty(value = "地区")
    private String region;

    @ApiModelProperty(value = "地区ID")
    private String regionId;

    @Min(message = "必须为数字且1为男,0为女", value = 0)
    @Max(message = "必须为数字且1为男,0为女", value = 1)
    @NotNull(message = "会员性别不能为空")
    @ApiModelProperty(value = "会员性别,1为男，0为女")
    private Integer sex;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "会员生日")
    private Date birthday;

    @ApiModelProperty(value = "会员头像")
    private String face;

}
