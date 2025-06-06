package org.duku.mall.framework.starter.common.modules.promotion.entity.dos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.duku.mall.framework.starter.common.modules.promotion.entity.enums.PromotionsScopeTypeEnum;
import org.duku.mall.framework.starter.common.modules.promotion.entity.enums.PromotionsStatusEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BasePromotions extends BaseEntity {

    private static final long serialVersionUID = 7814832369110695758L;

    @ApiModelProperty(value = "商家名称，如果是平台，这个值为 platform")
    private String storeName;

    @ApiModelProperty(value = "商家id，如果是平台，这个值为 0")
    private String storeId;

    @NotEmpty(message = "活动名称不能为空")
    @ApiModelProperty(value = "活动名称", required = true)
    private String promotionName;

    @ApiModelProperty(value = "活动开始时间", required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date,  pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    private Date startTime;

    @ApiModelProperty(value = "活动结束时间", required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date,  pattern = "yyyy-MM-dd HH:mm:ss || yyyy-MM-dd || yyyy/MM/dd HH:mm:ss|| yyyy/MM/dd ||epoch_millis")
    private Date endTime;

    /**
     * @see PromotionsScopeTypeEnum
     */
    @ApiModelProperty(value = "关联范围类型")
    private String scopeType = PromotionsScopeTypeEnum.PORTION_GOODS.name();


    @ApiModelProperty(value = "范围关联的id")
    private String scopeId;


    /**
     * @return 促销状态
     * @see PromotionsStatusEnum
     */
    public String getPromotionStatus() {
        if (endTime == null) {
            return startTime != null ? PromotionsStatusEnum.START.name() : PromotionsStatusEnum.CLOSE.name();
        }
        Date now = new Date();
        if (now.before(startTime)) {
            return PromotionsStatusEnum.NEW.name();
        } else if (endTime.before(now)) {
            return PromotionsStatusEnum.END.name();
        } else if (now.before(endTime)) {
            return PromotionsStatusEnum.START.name();
        }
        return PromotionsStatusEnum.CLOSE.name();
    }
}
