package org.duku.mall.framework.starter.common.modules.order.trade.entity.dos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;
import org.duku.mall.framework.starter.convention.enums.UserEnums;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("li_order_log")
@ApiModel(value = "订单日志")
@NoArgsConstructor
public class OrderLog extends BaseIdEntity {

    private static final long serialVersionUID = -1599270944927160096L;


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

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "操作者id(可以是卖家)")
    private String operatorId;
    /**
     * @see UserEnums
     */
    @ApiModelProperty(value = "操作者类型")
    private String operatorType;


    @ApiModelProperty(value = "操作者名称")
    private String operatorName;

    @ApiModelProperty(value = "日志信息")
    private String message;

    public OrderLog(String orderSn, String operatorId, String operatorType, String operatorName, String message) {
        this.orderSn = orderSn;
        this.operatorId = operatorId;
        this.operatorType = operatorType;
        this.operatorName = operatorName;
        this.message = message;
    }

    public String getCreateBy() {
        if (StringUtils.isEmpty(createBy)) {
            return "系统";
        }
        return createBy;
    }
}
