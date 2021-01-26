package com.afei.controller.mysql;

import com.afei.pojo.entity.Animal;
import com.afei.pojo.entity.Lesson;
import com.afei.pojo.entity.Student;
import com.afei.service.DbQueryService;
import com.afei.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stu")
public class MysqlController {


    @Autowired
    private DbQueryService service;


    @Autowired
    private LessonService lessonService;





    @GetMapping(value = "/query")
    public Student query(Integer id){

       return service.query(id);

    }



    @GetMapping(value = "/insert")
    public  void insert(){


    }


}
