package org.duku.mall.framework.starter.common.modules.page.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.page.entity.enums.ArticleCategoryEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_article_category")
@ApiModel(value = "文章分类")
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCategory extends BaseEntity {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "分类名称")
    @NotEmpty(message = "分类名称不能为空")
    private String articleCategoryName;

    @ApiModelProperty(value = "父分类ID")
    private String parentId;

    @ApiModelProperty(value = "排序")
    @Min(value = 0,message = "排序值最小0，最大9999999999")
    @Max(value = 999999999,message = "排序值最小0，最大9999999999")
    @NotNull(message = "排序值不能为空")
    private Integer sort;

    @ApiModelProperty(value = "层级")
    @Min(value = 0,message = "层级最小为0")
    @Max(value = 3,message = "层级最大为3")
    private Integer level;

    /**
     * @see ArticleCategoryEnum
     */
    @ApiModelProperty(value = "类型")
    private String type;

    public Integer getSort() {
        if (sort == null) {
            return 0;
        }
        return sort;
    }

    public Integer getLevel() {
        if (level == null) {
            return 1;
        }
        return level;
    }
}
