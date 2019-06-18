package com.afei.config.threadPool.threadpool;

import lombok.Data;


/**
 * @author gongxiangfei
 * @version 1.0
 * @dataTime
 * @descride fixedThreadPool execute方法参数类
 */
@Data
public class ThreadPoolRunablePojo implements Runnable {

    private int count;



    @Override
    public void run() {


        System.out.println(Thread.currentThread().getName()+"start to work "+count);

        try {

            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"been finished");


    }


    public static void main(String[] args){


        Thread thread = new Thread(new ThreadPoolRunablePojo());
        System.out.println(thread.getState());
        System.out.println(1);
        thread.start();
        System.out.println(thread.getState());
        System.out.println(2);
        thread.interrupt();
        System.out.println(thread.getState());
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isAlive());


    }
}
