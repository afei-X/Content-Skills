package com.afei.service.impl;

import com.afei.pojo.entity.Lesson;
import com.afei.pojo.entity.Student;
import com.afei.service.DbQueryService;
import com.afei.service.LessonService;
import com.afei.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DbQueryServiceImpl implements DbQueryService {



    @Autowired
    private StudentService studentService;

    @Autowired
    private LessonService lessonService;


    /**
     *
     * 事务传播机制： 由父传递到子， 验证是否急于aop模式实现。 this调用不生效
     *
     * try-catch 捕获事务异常，不阻碍接下来的流程/
     *
     * REQUIRED: 默认，如果当前有事务， 则加入当前事务，同步执行或者回滚， 如果当前没有事务，则创建一个新事务。
     * REQUIRES_NEW： 如果当前有事务， 则挂起当前事务，新建事务单独运行(和父事务没有关系)，如有没有事务，则创建一个新事务
     * SUPPORTS: 如果当前有事务，则加入当前事务中。 如果没有事务，则以非事务运行。
     * NOT_SUPPORTED: 如果当前有事务， 则将当前事务挂起，以非事务方式运行。 如果没有事务，同样以非事务状态运行。
     * NEVER: 如果当前有事务，则抛出异常 ，如果没有事务， 以非事务状态运行。
     * MANDATORY: 如果有事务，则加入当前事务， 如果当前没有事务，则抛出异常。
     * NESTED： 事务之间隔离，独自提交/回滚， 不影响其他事务。
     *
     *
     *
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void insert() {


        studentService.insert();


        lessonService.insert();
      //  int i=1/0;

    }



    @Override
    public Student query(Integer id) {
        return studentService.queryStudent(id);
    }
}
