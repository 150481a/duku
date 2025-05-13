package org.duku.mall.framework.starter.common.modules.search.entity.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class HotWordsDTO {
    @NotBlank(message = "搜索热词不能为空")
    @Size(max = 20, min = 1, message = "搜索热词长度限制在1-20")
    private String keywords;

    @NotNull(message = "分数不能为空")
    @Max(value = 9999999999L,message = "分数不能大于9999999999")
    @Min(value = -9999999999L,message = "分数不能小于9999999999")
    private Integer point;
}
