package com.afei.pojo.thread.creatAndStart;

/**
 * @author gongxiangfei
 */
public class ThreadExtends  extends Thread{


    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(ThreadExtends.currentThread().getId() +"我在测试通过继承Thread 的方式创建线程成功"+i);
        }
    }
}
