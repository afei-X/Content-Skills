package com.afei.pojo.thread.creatAndStart;

public class ThreadsImplements implements  Runnable {


    @Override
    public void run() {

        for (int i = 0; i <10 ; i++) {
            System.out.println("我在测试通过实现Runnable 的方式创建线程成功"+i);
        }

    }
}
