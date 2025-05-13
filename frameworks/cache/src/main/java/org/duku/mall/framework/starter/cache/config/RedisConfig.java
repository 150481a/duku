package org.duku.mall.framework.starter.cache.config;

import cn.hutool.core.text.CharSequenceUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONFactory;
import org.apache.commons.codec.digest.DigestUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * redis 自定义配置
 */
@Slf4j
@Configuration
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig extends CachingConfigurerSupport {


    private static final String REDIS_PREFIX = "redis://";

    @Value("${lili.cache.timeout:7200}")
    private Integer timeout;


    /**
     * 缓存管理器
     * 当有多个管理器的时候，必须使用该注解在一个管理器上注释：表示该管理器为默认的管理器
     * @param connectionFactory
     * @return 缓存管理器
     */
    @Bean
    @Primary
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        //初始化一个RedisCacheManager
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);

        //序列化方式2
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<Object>(Object.class);
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        //设置缓存过期时间
        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofSeconds(timeout));
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
        //设置白名单---非常重要********
        /*
        使用fastjson的时候：序列化时将class信息写入，反解析的时候，
        fastjson默认情况下会开启autoType的检查，相当于一个白名单检查，
        如果序列化信息中的类路径不在autoType中，
        反解析就会报com.alibaba.fastjson.JSONException: autoType is not support的异常
        可参考 https://blog.csdn.net/u012240455/article/details/80538540
        fastjson  1写法
         ParserConfig.getGlobalInstance().addAccept("cn.lili.");
        ParserConfig.getGlobalInstance().addAccept("cn.hutool.json.");
         */
        //fastjson 2写法
        JSONFactory.getDefaultObjectReaderProvider().addAutoTypeAccept("cn.lili.");
        JSONFactory.getDefaultObjectReaderProvider().addAutoTypeAccept("cn.hutool.json.");

        return redisCacheManager;
    }

    /**
     * redis连接工厂
     * @param lettuceConnectionFactory
     * @return 连接工厂
     */
    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //序列化
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        //value值的序列化采用fastJsonRedisSerializer
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        //key的序列化采用StringRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //设置连接工厂
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return redisTemplate;
    }


    /**
     * redisson客户端
     * @param redisProperties
     * @return 客户端
     * @throws Exception
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(RedisProperties redisProperties) {
        Config config = new Config();
        if (redisProperties.getSentinel() != null && !redisProperties.getSentinel().getNodes().isEmpty()) {
            // 哨兵模式

            SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
            sentinelServersConfig.setMasterName(redisProperties.getSentinel().getMaster());

            List<String> sentinelAddress = new ArrayList<>();
            for (String node : redisProperties.getSentinel().getNodes())
                sentinelAddress.add(REDIS_PREFIX + node);

            sentinelServersConfig.setSentinelAddresses(sentinelAddress);
            if (CharSequenceUtil.isNotEmpty(redisProperties.getSentinel().getPassword()))
                sentinelServersConfig.setSentinelPassword(redisProperties.getSentinel().getPassword());


        } else if (redisProperties.getCluster() != null && !redisProperties.getCluster().getNodes().isEmpty()) {
            // 集群模式
            ClusterServersConfig clusterServersConfig = config.useClusterServers();
            List<String> clusterAddress = new ArrayList<>();
            for (String node : redisProperties.getSentinel().getNodes())
                clusterAddress.add(REDIS_PREFIX + node);

            clusterServersConfig.setNodeAddresses(clusterAddress);
            if (CharSequenceUtil.isNotEmpty(redisProperties.getPassword()))
                clusterServersConfig.setPassword(redisProperties.getPassword());


        } else {
            // 单机模式
            SingleServerConfig singleServerConfig =
                    config.useSingleServer();
            singleServerConfig.setAddress(REDIS_PREFIX + redisProperties.getHost() + ":" + redisProperties.getPort());
            if (CharSequenceUtil.isNotEmpty(redisProperties.getPassword()))
                singleServerConfig.setPassword(redisProperties.getPassword());
            singleServerConfig.setPingConnectionInterval(1000);
        }
        return Redisson.create(config);
    }

    /**
     * 自定义缓存key生成策略，默认将使用该策略
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            HashMap<Object, Object> container = new HashMap<>(3);
            Class<?> targetClassClass = target.getClass();
            //类地址
            container.put("class", targetClassClass.getName());
            //方法名称
            container.put("methodName", method.getName());
            //包名称
            container.put("package", targetClassClass.getPackage());
            //参数列表
            for (int i = 0; i < params.length; i++)
                container.put(String.valueOf(i), params[i]);

            //转为JSON字符串
            String jsonString = JSON.toJSONString(container);
            //做SHA256 Hash计算，得到一个SHA256摘要作为Key
            return DigestUtils.sha256Hex(jsonString);
        };
    }


    public CacheErrorHandler errorHandler() {
        //异常处理，当Redis发生异常时，打印日志，但是程序正常走
        log.info("初始化 -> [{}]", "Redis CacheErrorHandler");
        return new CacheErrorHandler() {

            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
                log.error("Redis occur handleCacheGetError：key -> [{}]", key, e);
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
                log.error("Redis occur handleCachePutError：key -> [{}]；value -> [{}]", key, value, e);
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
                log.error("Redis occur handleCacheEvictError：key -> [{}]", key, e);
            }

            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                log.error("Redis occur handleCacheClearError：", e);
            }
        };
    }
}
