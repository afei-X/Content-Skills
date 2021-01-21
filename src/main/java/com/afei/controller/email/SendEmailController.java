package com.afei.controller.email;


import com.afei.config.threadPool.threadpool.ThreadPoolConfig;
import com.afei.config.threadPool.threadpool2sendemail.EmailRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {


    @Autowired
    private ThreadPoolConfig threadPoolConfig;



    @GetMapping(value = "/sendEmail")
    public void done(){
        threadPoolConfig.execute(new EmailRunnable());

    }
}
