package com.afei.controller;

import com.afei.pojo.designPattern.Single;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * volatile 修饰的变量是否可以保证数据安全问题
 *
 * 并发编程的三大概念：原子性，有序性，可见性
 *
 * 压测 多线程下并发下 数据问题
 * @author gongxiangfei
 */
@RestController
public class VolatileController {



    int i=10;

    @GetMapping(value = "/volatile")
    public void testVolatile(){


            new Thread(){
                public void run(){

                    i=0;

                };
            }.start();

            new Thread(){
                public void run(){
                    int j=i;

                    System.out.println(j);
                };
            }.start();
        }




    @GetMapping(value = "/singleton")
    public void testSingleton(){
        Single.getInstance().test();
    }

}



