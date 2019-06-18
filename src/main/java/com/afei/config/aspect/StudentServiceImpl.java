package com.afei.config.aspect;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/9.
 */
@Service
public class StudentServiceImpl  implements StudentService{

    @Override
    public  void show() {

        System.out.println("学生进行表演");
        //int i=1/0;

    }

}
