package org.duku.mall.framework.starter.common.modules.connect.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("li_connect")
@ApiModel(value = "联合登陆")
@NoArgsConstructor
public class Connect  extends BaseEntity {
    private static final long serialVersionUID = 1L;


    @CreatedBy
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建者", hidden = true)
    private String createBy;

    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("联合登录id")
    private String unionId;

    /**
     * @see org.duku.mall.framework.starter.common.modules.connect.entity.enums.ConnectEnum
     */
    @ApiModelProperty(value = "联合登录类型")
    private String unionType;


    public Connect(String userId, String unionId, String unionType) {
        this.userId = userId;
        this.unionId = unionId;
        this.unionType = unionType;
    }

}
