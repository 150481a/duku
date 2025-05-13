package org.duku.mall.framework.starter.common.modules.system.entity.dos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("li_app_version")
@ApiModel(value = "app版本控制")
public class AppVersion extends BaseIdEntity {

    private static final long serialVersionUID = 3034686331756935L;

    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @CreatedBy
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者", hidden = true)
    private String createBy;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "版本名称")
    private String versionName;

    @ApiModelProperty(value = "更新内容")
    private String content;

    @ApiModelProperty(value = "是否强制更新")
    private Boolean forceUpdate;

    @ApiModelProperty(value = "下载地址")
    private String downloadUrl;

    /**
     * @see AppType
     */
    @ApiModelProperty(value = "类型")
    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "版本更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date versionUpdateDate;
}
