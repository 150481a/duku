package org.duku.mall.framework.starter.common.trigger.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 信息队列传输促销信息实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponActivityMessage {
    /**
     * 促销id
     */
    private String couponActivityId;
}
