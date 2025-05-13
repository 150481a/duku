package org.duku.mall.framework.starter.common.modules.page.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ArticleVO {

    @ApiModelProperty(value = "文章ID")
    private String id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "分类名称")
    private String articleCategoryName;

    @ApiModelProperty(value = "文章排序")
    private Integer sort;

    @ApiModelProperty(value = "开启状态")
    private Boolean openStatus;
}
