package com.afei.config.mq;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * @author gongxiangfei
 * @desribe mq 生产者
 * @datatime 00-00-00
 */
@Service
public class ProducerMQ {

    @Value("${apache.rocketmq.producer.producerFroup}")
    private String producerGroup;

    @Value("${apache.rocketmq.nameserverAdder}")
    private String nameserverAddr;

    @Value("${apache.rocketmq.producer.topic}")
    private  String topic;

    public void defaultProducerMQ(){

        //生产者组名
        DefaultMQProducer mqProducer = new DefaultMQProducer(producerGroup);

        //指定nameserver的地址， 多个地址以； 隔开

        mqProducer.setInstanceName("能保持正");
        mqProducer.setNamesrvAddr(nameserverAddr);

        try {
            /**
             * producer 对象在使用之前必须调用start方法进行初始化，初始化一次即可
             *
             */
            mqProducer.start();

            /**
             * 创建一个消息实例，包含topic，tag和消息体
             *
             */
            Message msg = new Message(topic, "push", "rocket mq 第一次发送消息".getBytes());

            StopWatch watch = new StopWatch();
            watch.start();

            for (int i = 0; i < 10; i++) {
                SendResult result = mqProducer.send(msg,new MessageQueueSelector() {

                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                },1);
                System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
            }


            watch.stop();

            System.out.println("----------------发送十条消息耗时：" + watch.getTotalTimeMillis());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            mqProducer.shutdown();
        }


    }





}
