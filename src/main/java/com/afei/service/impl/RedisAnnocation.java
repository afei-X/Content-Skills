package com.afei.service.impl;

import com.afei.pojo.entity.Student;
import com.afei.pojo.entity.User;
import com.afei.service.RedisService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongxiangfei
 * @descride redis的操作
 * @dataTime 2018-11-03
 */
@CacheConfig(cacheNames = "redis_test_")
@Service
public class RedisAnnocation implements RedisService {




    @Cacheable(key = "#p0")
    @Override
    public Student queryList(String id){

        //List<Student> list = new ArrayList<>();

        Student s = new Student();
        s.setId(1);
        s.setFieldName("first-bllod");
        //list.add(s);

return s;



    }


}
