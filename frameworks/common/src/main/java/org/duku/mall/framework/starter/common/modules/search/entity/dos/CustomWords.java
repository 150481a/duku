package org.duku.mall.framework.starter.common.modules.search.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.hibernate.validator.constraints.Length;

@Data
@TableName("li_custom_words")
@ApiModel(value = "自定义分词")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomWords extends BaseEntity {

    private static final long serialVersionUID = 650889506808657977L;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "分词名称必填")
    @Length(max = 20, message = "分词名称长度不能大于20")
    private String name;


    @ApiModelProperty(value = "是否禁用: 0,禁用;1,不禁用")
    private Integer disabled;


    public CustomWords(String name) {
        this.name = name;
        this.disabled = 1;
    }
}
