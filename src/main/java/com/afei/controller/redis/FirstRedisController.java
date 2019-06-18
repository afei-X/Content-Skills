package com.afei.controller.redis;

import com.afei.pojo.entity.Student;
import com.afei.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRedisController {


    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "redis")
    public void queryList(String id){
        redisService.queryList(id);


    }
}
