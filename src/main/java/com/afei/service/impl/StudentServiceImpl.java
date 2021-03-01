package com.afei.service.impl;

import com.afei.mapper.StudentMapper;
import com.afei.pojo.entity.Student;
import com.afei.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/5/9.
 */
@Service
public class StudentServiceImpl implements StudentService {



    @Autowired
    private StudentMapper studentMapper;

    @Override
    public  void show() {

        System.out.println("学生进行表演");
        //int i=1/0;

    }

    @Transactional(propagation = Propagation.REQUIRED ,rollbackFor = Exception.class)
    @Override
    public void insert() {


        Student student = new Student();
        student.setName("sky");

        studentMapper.insert(student);

        //int i=1/0;


    }

    @Override
    public Student queryStudent(Integer id) {
        return studentMapper.queryStudent(id);
    }

}
