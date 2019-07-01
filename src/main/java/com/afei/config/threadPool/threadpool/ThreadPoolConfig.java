package com.afei.config.threadPool.threadpool;

import com.alibaba.rocketmq.common.ThreadFactoryImpl;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author gongxiangfei
 * @version 1.0
 * @dataTime 2019-01-02
 * @descride  线程池的配置类
 */
@Component
public class ThreadPoolConfig {


    //核心线程数
    private static final int CORE_POOL_SIZE = 30;

    //最大线程数
    private static final int MAX_POOL_SIZE = 50;

    //空闲线程的活跃时间
    private static final int KEEP_ALIVE_TIME = 200;

    private static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);


    //ThreadFactory threadFactory = new ThreadFactoryImpl("first-pool-%d");

    /**
     * Executors 的内部类
     */
    //ThreadFactory threadFactory = Executors.defaultThreadFactory();

    private  final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("first-pool-%d").build();


    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.MILLISECONDS, queue,threadFactory);


    public void execute(Runnable command){
        threadPoolExecutor.execute(command);
    }





    /*public static void main(String[] args){






       try {

           for (int i = 0; i < 40; i++) {

               ThreadPoolRunablePojo runablePojo = new ThreadPoolRunablePojo();
               runablePojo.setCount(i);
               threadPoolExecutor.execute(runablePojo);


           }
       } finally{

           System.out.println("主线程结束:" + Thread.currentThread().getName());
           System.out.println("睡之前的队列数量"+threadPoolExecutor.getQueue());
           System.out.println("睡之💰活跃线程的数量"+threadPoolExecutor.getPoolSize());
           System.out.println("睡之前的活跃线程数量"+threadPoolExecutor.getActiveCount());
           System.out.println("睡之前的活跃最大线程数量"+threadPoolExecutor.getLargestPoolSize());
       }


       Thread thread = Thread.currentThread();
       try {
           thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       System.out.println("睡之后的队列数量"+threadPoolExecutor.getQueue());
       System.out.println("睡之后线程数量"+threadPoolExecutor.getPoolSize());
       System.out.println("睡之后活跃线程数量："+threadPoolExecutor.getActiveCount());
       System.out.println("睡之后的活跃最大线程数量"+threadPoolExecutor.getLargestPoolSize());


   }*/
}
