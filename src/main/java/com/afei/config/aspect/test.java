package com.afei.config.aspect;

import com.afei.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class test {



    @Autowired
    private StudentService studentService;


    void  done(){
        
        studentService.show();
    }



    public static void main(String[] args){







    }
}
