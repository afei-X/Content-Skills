package com.afei.config.annotation;

import com.afei.config.aspect.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTest {


     @Autowired
     private StudentService studentService;


     @Test
     public void test()throws Exception{



          studentService.show();


     }
}
