package com.afei.controller.mq;

import com.afei.config.mq.ConsumerMQ;
import com.afei.config.mq.ProducerMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstMq {

    @Autowired
    private ProducerMQ mq;

    @Autowired
    private ConsumerMQ consumerMQ;

    @RequestMapping(value = "sendMsg",method = RequestMethod.GET)
    public void sendMq(){

        mq.defaultProducerMQ();
        //consumerMQ.consumerMq();

    }
}
