package org.duku.mall.framework.starter.common.modules.statistics.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;

import java.util.Date;

@Data
@TableName("li_s_platform_view_data")
@ApiModel(value = "平台pv统计")
public class PlatformViewData extends BaseIdEntity {

    @ApiModelProperty(value = "pv数量")
    private Long pvNum;

    @ApiModelProperty(value = "uv数量")
    private Long uvNum;


    @ApiModelProperty(value = "统计日")
    private Date date;

    //默认是平台流量统计//

    @ApiModelProperty(value = "店铺id")
    private String storeId = "-1";

}
