package org.duku.mall.framework.starter.common.modules.page.entity.params;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.common.vo.PageVO;

@Data
public class ArticleSearchParams extends PageVO {
    @ApiModelProperty(value = "分类ID")
    private String categoryId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "分类类型")
    private String type;

    public <T> QueryWrapper<T> queryWrapper() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(categoryId), "category_id", categoryId);
        queryWrapper.like(StringUtils.isNotBlank(title), "title", title);
        return queryWrapper;
    }
}
