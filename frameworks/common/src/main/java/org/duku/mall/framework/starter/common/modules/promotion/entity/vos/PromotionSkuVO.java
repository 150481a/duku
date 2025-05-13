package org.duku.mall.framework.starter.common.modules.promotion.entity.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.convention.enums.PromotionTypeEnum;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionSkuVO implements Serializable {
    private static final long serialVersionUID = -8587010496940375179L;

    /**
     * 促销类型
     * @see PromotionTypeEnum
     */
    private String promotionType;

    /**
     * 促销活动
     */
    private String activityId;
}
