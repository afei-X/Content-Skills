package com.afei.config.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author gongxiangfei
 * @describe 消费者mq
 * @datatime 00-00-00
 */
@Configuration
public class ConsumerMQ {


    @Value("${apache.rocketmq.consumer.PushConsumer}")
    private String consumerGroup;

    @Value("${apache.rocketmq.nameserverAdder}")
    private String nameserverAddr;

    @Value("${apache.rocketmq.consumer.topic}")
    private  String consumerTopic;

    @Value("${apache.rocketmq.producer.topic}")
    private  String producerTopic;

    @Bean
    public DefaultMQPushConsumer consumerMq(){

        System.out.println("------------------");

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);

        consumer.setNamesrvAddr(nameserverAddr);

        try {
            consumer.subscribe(producerTopic,"*");

            /*设置consumer第一次启动是从哪里消费，如果不是第一次，继续按照上次位置消费*/
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.setInstanceName("consumer instanceName");
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return consumer;
    }
}
