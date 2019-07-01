package com.afei.controller.threadpool;


import com.afei.config.threadPool.threadpool.ThreadPoolConfig;
import com.afei.config.threadPool.threadpool2sendemail.EmailRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadPoolController {


    @Autowired
    private ThreadPoolConfig threadPoolConfig;


    @GetMapping(value = "/send")
    public void done(){

        threadPoolConfig.execute(new EmailRunnable());
        System.out.println("发生成功");
    }


}
