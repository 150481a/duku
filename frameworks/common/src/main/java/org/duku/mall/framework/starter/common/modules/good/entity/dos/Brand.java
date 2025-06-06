package org.duku.mall.framework.starter.common.modules.good.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.hibernate.validator.constraints.Length;

@Data
@TableName("li_brand")
@ApiModel(value = "商品品牌")
public class Brand extends BaseEntity {

    private static final long serialVersionUID = -8236865838438521426L;

    @NotEmpty(message = "品牌名称不能为空")
    @Length(max = 20, message = "品牌名称应该小于20长度字符")
    @ApiModelProperty(value = "品牌名称", required = true)
    private String name;

    @NotEmpty(message = "品牌图标不能为空")
    @Length(max = 255, message = "品牌图标地址长度超过255字符")
    @ApiModelProperty(value = "品牌图标", required = true)
    private String logo;
}
