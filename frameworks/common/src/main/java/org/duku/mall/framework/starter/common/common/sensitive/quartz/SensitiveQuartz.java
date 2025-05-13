package org.duku.mall.framework.starter.common.common.sensitive.quartz;

import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.sensitive.SensitiveWordsFilter;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 *间隔更新敏感词
 */
@Slf4j
public class SensitiveQuartz  extends QuartzJobBean {

    @Autowired
    private SingletonCache<List<String>> cache;

    /**
     * 定时更新敏感词信息
     *
     * @param jobExecutionContext
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("敏感词定时更新");
        List<String> sensitives = cache.get(CachePrefix.SENSITIVE.getPrefix());
        if (sensitives == null || sensitives.isEmpty()) {
            return;
        }
        SensitiveWordsFilter.init(sensitives);
    }
}
