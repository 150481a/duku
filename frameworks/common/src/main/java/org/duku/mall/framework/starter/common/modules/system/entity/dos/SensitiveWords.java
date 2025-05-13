package org.duku.mall.framework.starter.common.modules.system.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_sensitive_words")
@ApiModel(value = "敏感词")
public class SensitiveWords extends BaseEntity {
    /**
     * 敏感词名称
     */
    @ApiModelProperty(value = "敏感词名称")
    @NotEmpty(message = "敏感词必填")
    @Size(min = 2, max = 20)
    private String sensitiveWord;
}
