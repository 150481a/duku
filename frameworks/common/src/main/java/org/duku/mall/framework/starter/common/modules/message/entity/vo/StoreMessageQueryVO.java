package org.duku.mall.framework.starter.common.modules.message.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.duku.mall.framework.starter.common.modules.message.entity.enums.MessageStatusEnum;

import java.io.Serializable;

@Data
@ApiModel(value = "消息")
public class StoreMessageQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @see MessageStatusEnum
     */
    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "消息id")
    private String messageId;

    @ApiModelProperty(value = "商家id")
    private String storeId;
}
