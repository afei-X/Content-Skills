package com.afei.pojo.thread.volatile1;

/**
 * @author gongxiangfei
 * @description:  volatile/普通变量 深入了解
 * @Date 2019/7/22 11:55 AM
 */
public class VolatileThread extends Thread{



    private static  boolean flag = false;
       //无限循环,等待flag变为true时才跳出循环


    /*普通变量在高频率的读取情况下，不会将当前线程的副本变量刷新到主内存中，反之回刷新到主内存中*/
    /*此时的flag属于普通变量，在while() 循环体中*/
    @Override
    public void run() {while (!flag){

        /**
         * 对变量读取频率很高的情况下，虚拟机才不会及时回写主内存，而当频率没有达到虚拟机认为的高频率时，
         * 普通变量和volatile是同样的处理逻辑。如在每个循环中执行System.out.println(1)加大了读取变量的时间间隔，
         * 使虚拟机认为读取频率并不那么高，所以实现了和volatile的效果
         */

        System.out.println(1);
    };}

    public static void main(String[] args) throws Exception {

        new VolatileThread().start();
        //sleep的目的是等待线程启动完毕,也就是说进入run的无限循环体了
        Thread.sleep(100);
        flag = true;
    }
}
