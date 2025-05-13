package org.duku.mall.framework.starter.common.modules.page.entity.dos;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.page.entity.enums.ArticleEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.hibernate.validator.constraints.Length;

@Data
@TableName("li_article")
@ApiModel(value = "文章")
public class Article extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章标题")
    @NotEmpty(message = "文章标题不能为空")
    @Length(max = 30, message = "文章标题不能超过30个字符")
    private String title;

    @ApiModelProperty(value = "分类id")
    @NotNull(message = "文章分类不能为空")
    private String categoryId;

    @ApiModelProperty(value = "文章排序")
    private Integer sort;

    @ApiModelProperty(value = "文章内容")
    @NotEmpty(message = "文章内容不能为空")
    private String content;

    @ApiModelProperty(value = "状态")
    private Boolean openStatus;
    /**
     * @see ArticleEnum
     */
    @ApiModelProperty(value = "类型")
    private String type;

    public String getContent() {
        if (CharSequenceUtil.isNotEmpty(content)) {
            return HtmlUtil.unescape(content);
        }
        return content;
    }
}
