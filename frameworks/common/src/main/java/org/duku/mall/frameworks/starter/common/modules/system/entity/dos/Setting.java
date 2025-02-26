package org.duku.mall.frameworks.starter.common.modules.system.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.frameworks.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_setting")
@ApiModel(value = "配置")
@NoArgsConstructor
public class Setting extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "配置值value")
    private String settingValue;
}
