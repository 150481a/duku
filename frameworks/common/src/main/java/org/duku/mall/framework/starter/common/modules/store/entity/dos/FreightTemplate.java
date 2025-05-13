package org.duku.mall.framework.starter.common.modules.store.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_freight_template")
@ApiModel(value = "运费模板")
public class FreightTemplate extends BaseEntity {

    @ApiModelProperty(value = "店铺ID", hidden = true)
    private String storeId;

    @NotEmpty(message = "模板名称不能为空")
    @ApiModelProperty(value = "模板名称")
    private String name;

    /**
     * @see FreightTemplateEnum
     */
    @NotEmpty(message = "计价方式不能为空")
    @ApiModelProperty(value = "计价方式：按件、按重量", allowableValues = "WEIGHT,NUM,FREE")
    private String pricingMethod;
}
