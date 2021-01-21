package com.afei.service.impl;

import com.afei.pojo.entity.Student;
import com.afei.pojo.entity.User;
import com.afei.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongxiangfei
 * @descride redis的操作
 * @dataTime 2018-11-03
 */
@CacheConfig(cacheNames = "cacheConfig")
@Service
public class RedisAnnocation implements RedisService {


    @Cacheable(value = "cache",key = "#p0")
    @Override
    public Student queryList(String name){

        System.out.println(name);
        Student s = new Student();
        s.setId(1);
        s.setFieldName("first-bllod");
        s.setName(name);
        return s;
    }

    @CacheEvict(value = "cache",key = "#p0")
    @Override
    public void delete(String name) {

    }
}
