package com.afei.pojo.thread.waitandnotify;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * @author gongxiangfei
 * @describe 等待--通知线程信息通知和同步
 * @dataTime 3-11
 */
public class WaitNotifyDemo {

    private static boolean flag=true;
    private static Object lock=new Object();

    public static void main(String[] args){
        Thread waitThread = new Thread(new Wait(), "waitThread");
        waitThread.start();

        Thread notifyThread = new Thread(new Notify(), "notifyThread");
        notifyThread.start();

    }

    /*wait */
    static class Wait implements Runnable{

        @Override
        public void run() {

            //加锁，拥有lock的monitor
            synchronized (lock){

                while (flag){

                    try {
                        System.out.println(Thread.currentThread()+"falg is :"+flag+"; wait @ "+ new SimpleDateFormat(
                                "HH:mm:ss").format(System.currentTimeMillis()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                /*条件满足时，完成工作*/
                System.out.println(Thread.currentThread()+"falg is :"+flag+"; wait @ "+ new SimpleDateFormat(
                        "HH:mm:ss").format(System.currentTimeMillis()));
            }
        }
    }


    static class Notify implements Runnable{

        @Override
        public void run() {

            //加锁
            synchronized (lock){

                try {

                    //获取lock的锁，然后进行通知，在通知的时候并不会释放lock的锁。只有执行完成synchroinzed代码块的时候才会释放锁
                    //当前线程释放锁之后，等待线程才会从wait方法中返回。

                    System.out.println(Thread.currentThread()+"hold lock.notify flag is @"+ flag+new SimpleDateFormat(
                            "HH:mm:ss").format(System.currentTimeMillis()));

                    lock.notifyAll();

                    flag=false;
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (lock){

                try {

                    System.out.println(Thread.currentThread()+"hold lock again.notify,flag is  @"+flag+ new SimpleDateFormat(
                            "HH:mm:ss").format(System.currentTimeMillis()));
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

}
