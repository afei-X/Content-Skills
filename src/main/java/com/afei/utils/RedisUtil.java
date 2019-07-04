package com.afei.utils;

import com.afei.config.redis.RSToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @author gongxiangfei
 * @description:  redis 工具类
 * @Date 2019/7/2 8:10 PM
 */
@Component
public class RedisUtil {



    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private RedisTemplate redisTemplate;

    private static final Long RELEASE_SUCCESS = 1L;


    public  Object lock(String key, String value, RSToken rsToken) {

        Object execute = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                Jedis jedis = (Jedis)redisConnection.getNativeConnection();
                return jedis.set(key,value,"NX","EX",rsToken.timeout());


            }
        });

        //one question 需要进行线程容错保护吗
        if("OK".equals(execute)){
            logger.error("获取redis分布式锁成功");
        }else{
            logger.error("redis分布式锁加锁失败");
        }

        return execute;
    }

    public Boolean deleteLock(String lockKey,String value) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        Boolean result = (Boolean) redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {

                Jedis jedis = (Jedis) connection.getNativeConnection();
                Object eval = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(value));

                if (RELEASE_SUCCESS.equals(eval)) {

                    return true;
                }
                return false;
            }
        });


        return  result;


    }
}
