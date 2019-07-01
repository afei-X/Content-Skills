package com.afei.pojo.designPattern.oberver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author gongxiangfei
 * @describe event  监听器
 * @dataTime now();
 */

@Component
public class FreeListener implements ApplicationListener<FreeEvent> {


    @Override
    public void onApplicationEvent(FreeEvent event) {

        System.out.println(Thread.currentThread().getName());

        System.out.println("监控事件成功");
    }

    static class context extends AbstractApplicationContext{


        @Override
        protected void refreshBeanFactory() throws BeansException, IllegalStateException {

        }

        @Override
        protected void closeBeanFactory() {

        }

        @Override
        public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
            return null;
        }

        public static void main(String[] args){

            context context = new context();
            System.out.println(context);
        }
    }
}
