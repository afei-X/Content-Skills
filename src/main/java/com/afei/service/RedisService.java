package com.afei.service;

import com.afei.pojo.entity.Student;

import java.util.List;

public interface RedisService {

    /**
     * redis 测试
     */
    Student queryList(String name);

    void delete(String name);
}
