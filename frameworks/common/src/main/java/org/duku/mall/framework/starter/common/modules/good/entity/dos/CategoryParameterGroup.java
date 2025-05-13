package org.duku.mall.framework.starter.common.modules.good.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("li_category_parameter_group")
@ApiModel(value = "分类绑定参数组")
public class CategoryParameterGroup extends BaseEntity {
    private static final long serialVersionUID = -3254446505349029420L;

    /**
     * 参数组名称
     */
    @ApiModelProperty(value = "参数组名称", required = true)
    @NotEmpty(message = "参数组名称不能为空")
    @Length(max = 20, message = "参数组名称不能超过20字")
    private String groupName;
    /**
     * 关联分类id
     */
    @ApiModelProperty(value = "关联分类id", required = true)
    @NotNull(message = "关联的分类不能为空")
    private String categoryId;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", hidden = true)
    private Integer sort;
}
