package com.afei.config.threadPool.threadpool2sendemail;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author gongxiangfei
 * @describe 线程池发送邮件
 * @dataTime 2019-05-28
 */
public class ThreadPoolToSendEmail {



    public  static ThreadPoolExecutor getThreadPoolExecutor(){


        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("email-pool-%d").build();

        return new ThreadPoolExecutor(30, 50, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(200),factory);


    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("这是业务操作");

        Callable<Object> callable = Executors.callable(new EmailRunnable(),new Object());
        Future<Object> submit = ThreadPoolToSendEmail.getThreadPoolExecutor().submit(callable);
        System.out.println(submit.get());


    }






}
