package org.duku.mall.framework.starter.common.common.sensitive.init;

import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.cache.CachePrefix;
import org.duku.mall.framework.starter.cache.SingletonCache;
import org.duku.mall.framework.starter.common.common.sensitive.SensitiveWordsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class SensitiveWordsLoader implements ApplicationRunner {

    @Autowired
    private SingletonCache<List<String>> cache;

    /**
     * 程序启动时，获取最新的需要过滤的敏感词
     * <p>
     * 这里即便缓存中为空也没关系，定时任务会定时重新加载敏感词
     *
     * @param args 启动参数
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> sensitives = cache.get(CachePrefix.SENSITIVE.getPrefix());
        log.info("系统初始化敏感词");
        if (sensitives == null || sensitives.isEmpty()) {
            return;
        }
        SensitiveWordsFilter.init(sensitives);
    }
}
