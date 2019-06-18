package com.afei.config.threadPool.threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gongxiangfei
 * @version 1.0
 * @dataTime 1028-12-18
 * @descide 线程池的使用
 */
public class ThreadPool {


    public static  void  main(String[] args){

        /**
         * 测试固定线程池的使用
         * 特点： 1.corePoolSize==maximumPoolSize
         * 2.队列长度没有限制
         *
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {

            ThreadPoolRunablePojo runablePojo = new ThreadPoolRunablePojo();
            runablePojo.setCount(i);
            executorService.execute(runablePojo);
        }

        System.out.println("主线程结束--------");
    }

}
