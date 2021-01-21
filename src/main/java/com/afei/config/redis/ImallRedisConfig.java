//package com.afei.config.redis;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCachePrefix;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.util.Collection;
//import java.util.Map;
//
///**
// * 配置RedisTemplate
// */
//@Configuration
//@ConditionalOnProperty(name = "iyd.redisTemplate.isenable", havingValue = "true", matchIfMissing = false)
//@EnableCaching
//@ConfigurationProperties("iyd.redisTemplate")
//public class ImallRedisConfig {
//
//    @Value("${iyd.redisTemplate.cacheNamePrefix:${spring.application.name:}}")
//    private String cacheNamePrefix;
//
//    private Map<String, Long> expires;
//
//
//    @Bean
//    @ConfigurationProperties("iyd.redisTemplate.manage")
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new CustomizedRedisCacheManager(redisTemplate);
//        rcm.setUsePrefix(true);
//        rcm.setCachePrefix(redisCachePrefix());
//        rcm.setExpires(expires);
//        return rcm;
//    }
//
//
//    /**
//     * 重写getMissingCache 解决获取缓存为null对象
//     */
//    private class CustomizedRedisCacheManager extends RedisCacheManager {
//        public CustomizedRedisCacheManager(RedisOperations redisOperations) {
//            super(redisOperations);
//        }
//
//        public CustomizedRedisCacheManager(RedisOperations redisOperations, Collection<String> cacheNames, boolean cacheNullValues) {
//            super(redisOperations, cacheNames, cacheNullValues);
//        }
//
//        public CustomizedRedisCacheManager(RedisOperations redisOperations, Collection<String> cacheNames) {
//            super(redisOperations, cacheNames);
//        }
//
//        @Override
//        protected Cache getMissingCache(String name) {
//            long expiration = computeExpiration(name);
//
//            return new RedisCacheReform(
//                    name,
//                    (this.isUsePrefix() ? this.getCachePrefix().prefix(name) : null),
//                    this.getRedisOperations(),
//                    expiration);
//        }
//    }
//
//
//    private RedisCachePrefix redisCachePrefix() {
//        return new ImallRedisCachePrefix(cacheNamePrefix);
//    }
//
//
//    @Bean
//    public Jackson2JsonRedisSerializer jackson2JsonRedisSerializer() {
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        //定义value的序列化方式
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        return jackson2JsonRedisSerializer;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory,Jackson2JsonRedisSerializer jackson2JsonRedisSerializer) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        //定义key序列化方式
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    public void setExpires(Map<String, Long> expires) {
//        this.expires = expires;
//    }
//
//    public Map<String, Long> getExpires() {
//        return expires;
//    }
//
//    public class ImallRedisCachePrefix implements RedisCachePrefix {
//
//        private final RedisSerializer serializer = new StringRedisSerializer();
//        private final String delimiter;
//        private final String prefix;
//
//        public ImallRedisCachePrefix(String prefix) {
//            this.delimiter = ":";
//            this.prefix = prefix;
//        }
//
//        @Override
//        public byte[] prefix(String cacheName) {
//            String str = (prefix != null ? prefix.concat(delimiter).concat(cacheName).concat(delimiter) : cacheName.concat(delimiter));
//            return serializer.serialize(str);
//        }
//    }
//}
