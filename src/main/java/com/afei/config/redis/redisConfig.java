package com.afei.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author gongxiangfei
 * @descride redis的配置类 springcache整合redis
 * @datatime 2018-11-29
 */
@Configuration
@EnableCaching
public class redisConfig extends CachingConfigurerSupport {


    @Value("${spring.application.name}")
    private  String prefixName;


    @Bean
    @SuppressWarnings("rawtypes")
    public CacheManager cacheManager(RedisTemplate redisTemplate) {


        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //设置redis的名称
        //cacheManager.setCacheNames(Arrays.asList("redis_first_"));
        //设置开启前缀
        cacheManager.setUsePrefix(true);
        //设置默认的前缀
        //cacheManager.setCachePrefix(new DefaultRedisCachePrefix(prefixName));
        cacheManager.setDefaultExpiration(3000);

        return  cacheManager;
    }



    /**
     * 配置redis
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){

        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer<Object> serializer =
                new Jackson2JsonRedisSerializer<>(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);
        template.setValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }


    /*@Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }*/


}
