package org.duku.mall.framework.starter.common.modules.promotion.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

import java.math.BigDecimal;


@Data
@TableName("li_points_goods_category")
@ApiModel(value = "积分商品分类")
@AllArgsConstructor
@NoArgsConstructor
public class PointsGoodsCategory extends BaseEntity {
    private static final long serialVersionUID = 4689246801280318515L;

    @NotEmpty(message = "分类名称不能为空")
    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "父id, 根节点为0")
    private String parentId;

    @ApiModelProperty(value = "层级, 从0开始")
    private Integer level;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;
}
