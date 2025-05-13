package org.duku.mall.framework.starter.common.modules.message.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;

@Data
@TableName("li_short_link")
@ApiModel(value = "短链接/暂时只用于小程序二维码业务")
public class ShortLink extends BaseIdEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原始参数")
    private String originalParams;
}
