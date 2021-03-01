package com.afei.service;

import com.afei.pojo.entity.Student;

/**
 * Created by Administrator on 2018/5/9.
 */
public interface StudentService {

    void show();

    void insert();

    Student queryStudent(Integer id);
}
