package org.duku.mall.framework.starter.common.modules.good.entity.params;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.vo.PageVO;

import java.math.BigDecimal;

@Data
public class CategorySearchParams extends PageVO {

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private String parentId;

    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "佣金比例")
    private BigDecimal commissionRate;

    @ApiModelProperty(value = "父节点名称")
    private String parentTitle;

    @ApiModelProperty(value = "是否禁用")
    private Boolean deleteFlag;

    public <T > QueryWrapper<T> queryWrapper() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(name != null, "name", name);
        queryWrapper.like(parentTitle != null, "parent_title", parentTitle);
        queryWrapper.eq(parentId != null, "parent_id", parentId);
        queryWrapper.eq(level != null, "level", level);
        queryWrapper.eq(sortOrder != null, "sort_order", sortOrder);
        queryWrapper.eq(commissionRate != null, "commission_rate", commissionRate);
        queryWrapper.eq(deleteFlag != null, "delete_flag", deleteFlag);
        return queryWrapper;
    }
}
