package org.duku.mall.framework.starter.common.modules.good.entity.dos;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_category_specification")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "商品分类规格")
public class CategorySpecification extends BaseEntity {


    private static final long serialVersionUID = -4041367493342243147L;
    /**
     * 分类id
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value = "分类id")
    private String categoryId;
    /**
     * 规格id
     */
    @TableField(value = "specification_id")
    @ApiModelProperty(value = "规格id")
    private String specificationId;
}
