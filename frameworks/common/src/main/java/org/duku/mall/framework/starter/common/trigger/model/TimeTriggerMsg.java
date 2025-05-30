package org.duku.mall.framework.starter.common.trigger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 延时任务消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeTriggerMsg implements Serializable {
    private static final long serialVersionUID = 8897917127201859535L;

    /**
     * 执行器beanId
     */
    private String triggerExecutor;

    /**
     * 执行器 执行时间
     */
    private Long triggerTime;

    /**
     * 执行器参数
     */
    private Object param;

    /**
     * 唯一KEY
     */
    private String uniqueKey;

    /**
     * 信息队列主题
     */
    private String topic;
}
