package com.afei.pojo.designPattern.productandconsumer;

import java.util.LinkedList;

/**
 * @author gongxiangfei
 * @description: 生产者消费者模式
 * @Date 2019/7/16 7:25 PM
 */
public class ProductAndConsumer {


    private static final LinkedList LIST= new LinkedList<>();

    private static Integer COUNT=5;



    public static void main(String[] args){

        for (int i = 0; i <10 ; i++) {

            new Thread(new Productor()).start();

            new Thread(new Consumer()).start();
        }



    }




    static class Productor implements Runnable{

        @Override
        public void run() {

            synchronized (LIST){
                while(LIST.size()>0){
                    System.out.println("生产者生产数量超过容量"+Thread.currentThread().getName());
                    try {
                        wait();
                        System.out.println("生产者生产数量超过容量，进行退出");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                LIST.add(LIST.size());

                LIST.notifyAll();
            }


        }
    }

    static class Consumer implements Runnable{

        @Override
        public void run() {

            synchronized (LIST){
                while(LIST.size()==0){

                    System.out.println("容量为空"+Thread.currentThread().getName());

                    try {
                        wait();
                        System.out.println("容量为空，退出");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                LIST.remove();
                LIST.notifyAll();
            }
        }
    }

}
