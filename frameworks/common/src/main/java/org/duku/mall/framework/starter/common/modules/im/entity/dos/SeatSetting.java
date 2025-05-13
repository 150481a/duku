package org.duku.mall.framework.starter.common.modules.im.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseTenantEntity;

@Data
@TableName("li_seat_setting")
@ApiModel(value = "坐席设置")
@NoArgsConstructor
public class SeatSetting extends BaseTenantEntity {
    @ApiModelProperty(value = "租户idid")
    private String tenantId;

    @ApiModelProperty(value = "欢迎语")
    private String welcome;

    @ApiModelProperty(value = "离线自动回复")
    private String outLineAutoReply;

    @ApiModelProperty(value = "长时间自动回复")
    private String longTermAutoReply;

}
