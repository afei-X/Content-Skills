package com.afei.controller.oberver;

import com.afei.pojo.designPattern.oberver.HostSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gongxiangfei
 * @describe 观察者模式
 * @dataTime now();
 */
@RestController
public class OberverController {



    @Autowired
    private HostSubject hostSubject;


    @GetMapping(value = "oberver")
    public void test(){

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                    hostSubject.publish();
            }
        });

        System.out.println(Thread.currentThread().getName());

    }



}
