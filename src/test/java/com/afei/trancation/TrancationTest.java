package com.afei.trancation;

import com.afei.pojo.entity.Lesson;
import com.afei.pojo.entity.Student;
import com.afei.service.DbQueryService;
import com.afei.service.LessonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author: afei
 * @Description: TrancationTest  事务验证
 * @date: 2021/1/26 2:21 下午
 * @version : 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrancationTest {



    @Autowired
    private DbQueryService service;



    @Test
    public  void insert(){

        service.insert();

    }

}
