package org.duku.mall.framework.starter.common.modules.page.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;

@Data
@TableName("li_special")
@ApiModel(value = "专题活动")
public class Special extends BaseEntity {
    @ApiModelProperty(value = "专题活动名称")
    private String specialName;

    /**
     * @see ClientTypeEnum
     */
    @ApiModelProperty(value = "楼层对应连接端类型", allowableValues = "PC,H5,WECHAT_MP,APP")
    private String clientType;

    @ApiModelProperty(value = "页面ID")
    private String pageDataId;
}
