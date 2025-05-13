package org.duku.mall.framework.starter.common.modules.member.entity.dos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("li_member_sign")
@ApiModel(value = "会员签到")
public class MemberSign extends BaseIdEntity {
    private static final long serialVersionUID = 1L;

    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;

    @ApiModelProperty(value = "会员用户名")
    private String memberName;

    @ApiModelProperty(value = "会员用户ID")
    private String memberId;

    @ApiModelProperty(value = "连续签到天数")
    private Integer signDay;


    @ApiModelProperty(value = "签到日 为数字 从现在减去19700101 的日期")
    private Integer day;
}
