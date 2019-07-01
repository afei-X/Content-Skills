package com.afei.pojo.designPattern.oberver;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class HostSubject implements ApplicationEventPublisherAware {


    private ApplicationEventPublisher eventPublisher;



    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

        this.eventPublisher=applicationEventPublisher;

    }


    public void publish(){

        System.out.println(Thread.currentThread().getName());

        eventPublisher.publishEvent(new FreeEvent("发布事件"));

    }


}
