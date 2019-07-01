package com.afei.controller.Spike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @author gongxiangfei
 * @describe 秒杀接口
 * @dataTime now();
 */
@RestController
public class TestController {



    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public Object test(){

        Object a = redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                Jedis jedis = (Jedis) redisConnection.getNativeConnection();

                return jedis.evalsha("5c98ac47dfb3928dbb401ac2d4c905b2083cbf4e", 1, "a", "1");


            }
        });
        Long result = (Long) a;


       return result>0?"Success":"Fail";

    }
}
