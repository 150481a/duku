package org.duku.mall.framework.starter.common.modules.wechat.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.order.order.entity.enums.OrderStatusEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;


@Data
@TableName("li_wechat_message")
@ApiModel(value = "微信消息")
public class WechatMessage extends BaseEntity {


    private static final long serialVersionUID = -9157586585885836755L;

    @ApiModelProperty(value = "模版名称")
    private String name;

    @ApiModelProperty(value = "微信模版码")
    private String code;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "是否开启")
    private Boolean enable = true;

    /**
     * @see OrderStatusEnum
     */
    @ApiModelProperty("订单状态")
    private String orderStatus;

    @ApiModelProperty(value = "模版头部信息")
    private String first;

    @ApiModelProperty(value = "模版备注（位于最下方）")
    private String remark;
}
