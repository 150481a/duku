package org.duku.mall.frameworks.starter.common.trigger.delay;

import lombok.extern.slf4j.Slf4j;
import org.duku.mall.frameworks.starter.cache.SingletonCache;
import org.duku.mall.frameworks.starter.common.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class AbstractDelayQueueMachineFactory {

    @Autowired
    private SingletonCache cache;


    /**
     * 插入任务id到延时队列
     * @param jobId 任务id
     * @param triggerTime 延时时间
     * @return
     */
    public boolean addJob(String  jobId,Long  triggerTime){
        //redis 中排序时间
        long delaySeconds = triggerTime / 1000;
        //增加延时任务 参数依次为：队列名称、执行时间、任务id
        boolean result = cache.zAdd(setDelayQueueName(), delaySeconds, jobId);
        log.info("增加延时任务, 缓存key {}, 执行时间 {},任务id {}", setDelayQueueName(), DateUtil.toString(triggerTime), jobId);
        return result;
    }

    /**
     * 要实现延时队列的名字
     * @return 延时队列的名字
     */
    public abstract String setDelayQueueName();

}
