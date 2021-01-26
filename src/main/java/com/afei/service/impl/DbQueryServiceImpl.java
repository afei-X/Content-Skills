package com.afei.service.impl;

import com.afei.mapper.StudentMapper;
import com.afei.pojo.entity.Student;
import com.afei.service.DbQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbQueryServiceImpl implements DbQueryService {



    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public Student query(Integer id) {
        return studentMapper.queryStudent(id);
    }
}
