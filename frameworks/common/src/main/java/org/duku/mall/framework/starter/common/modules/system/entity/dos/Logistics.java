package org.duku.mall.framework.starter.common.modules.system.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_logistics")
@ApiModel(value = "物流公司")
public class Logistics extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "物流公司名称必填")
    @ApiModelProperty(value = "物流公司名称")
    private String name;

    @NotEmpty(message = "物流公司code必填")
    @ApiModelProperty(value = "物流公司code")
    private String code;

    @ApiModelProperty(value = "支持电子面单")
    private String standBy;

    @ApiModelProperty(value = "物流公司电子面单表单")
    private String formItems;

    @ApiModelProperty(value = "禁用状态 OPEN：开启，CLOSE：禁用")
    private String disabled;
}
