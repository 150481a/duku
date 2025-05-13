package org.duku.mall.framework.starter.common.modules.im.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_qa")
@ApiModel(value = "租户问答")
@NoArgsConstructor
public class QA extends BaseEntity {
    @ApiModelProperty(value = "租户id")
    private Integer tenantId;

    @ApiModelProperty(value = "问题")
    private String question;

    @ApiModelProperty(value = "答案")
    private String answer;
}
