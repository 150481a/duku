package org.duku.mall.framework.starter.common.modules.verification.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.verification.entity.enums.VerificationSourceEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_verification_source")
@ApiModel(value = "验证码资源维护")
public class VerificationSource extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "资源地址")
    private String resource;

    /**
     * @see VerificationSourceEnum
     */
    @ApiModelProperty(value = "验证码资源类型 SLIDER/SOURCE")
    private String type;
}
