package com.afei.thread;

import com.afei.pojo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ReentrantLockTest {

    /**
     * lock 的方式实现线程安全
     * lamada 方式创建线程
     * @throws Exception
     */
    @Test
    public void test()throws Exception{

        Lock lock = new ReentrantLock();


        int j=0;
        lock.lock();
        for (int i = 0; i <100 ; i++) {
            new Thread(() -> System.out.println("1223")).start();
        }


        lock.unlock();

    }


    /**
     * 创建线程
     * lock加锁
     * @throws Exception
     */
    @Test
     public void test1()throws Exception{

        ReentrantLock lock = new ReentrantLock();

        int i=0;
        for (int j = 0; j <100 ; j++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();

                    System.out.println(i+1);

                    lock.unlock();
                }
            }).start();
        }
    }

    public  static  void  main(String[] args){

        ReentrantLock lock = new ReentrantLock();
        for (int j = 0; j <100 ; j++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();

                    System.out.println();

                    lock.unlock();
                }
            }).start();
        }


    }








}
