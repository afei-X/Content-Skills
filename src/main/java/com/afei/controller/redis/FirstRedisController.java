package com.afei.controller.redis;

import com.afei.pojo.entity.Student;
import com.afei.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRedisController {


    @Autowired
    private RedisService redisService;

    @GetMapping(value = "/redis")
    public Student queryList(String name){


       return redisService.queryList(name);

    }

    @GetMapping(value = "/delete")
    public void delete(String name){

        redisService.delete(name);
    }
}
