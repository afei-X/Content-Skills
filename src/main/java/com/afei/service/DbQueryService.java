package com.afei.service;

import com.afei.pojo.entity.Student;

/**
 * @author: afei
 * @Description: DbQueryService  mysql-mybatis demo
 * @date: 2021/1/25 8:01 下午
 * @version : 1.0
 */
public interface DbQueryService {

    void insert(Student student);


    /**
     * 查询
     * @param id
     * @return
     */
    Student query(Integer id);







}
