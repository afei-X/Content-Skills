package com.afei.controller.email;


import com.afei.config.threadPool.threadpool2sendemail.EmailRunnable;
import com.afei.config.threadPool.threadpool2sendemail.ThreadPoolToSendEmail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {



    @GetMapping(value = "/sendEmail")
    public void done(){

        ThreadPoolToSendEmail.getThreadPoolExecutor().execute(new EmailRunnable());
    }
}
