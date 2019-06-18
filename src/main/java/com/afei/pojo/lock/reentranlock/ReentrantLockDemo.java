package com.afei.pojo.lock.reentranlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gongxiangfei
 * @describe ReentrantLock 类图
 * @dataTime now();
 */
public class ReentrantLockDemo {







    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        demo demo = new demo();
        for (int i = 0; i <2 ; i++) {
            executorService.execute(demo);
        }

   }


    static  class demo implements  Runnable{

       volatile int i=0;
       Lock lock = new ReentrantLock(true);
       @Override
       public void run() {

           lock.lock();
           i=i+1;
           System.out.println(i);
           lock.unlock();
       }
   }

}
