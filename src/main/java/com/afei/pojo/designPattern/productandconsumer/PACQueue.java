package com.afei.pojo.designPattern.productandconsumer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author gongxiangfei
 * @description: 队列实现生产者和消费者
 * @Date 2019/7/16 8:21 PM
 */
public class PACQueue {



    private static LinkedBlockingQueue<Integer> queues = new LinkedBlockingQueue<>();

    public static void main(String[] args){



        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i <5; i++) {

           pool.submit(new Producer(i));
           pool.submit(new Consumer());
        }
    }


    static class Producer implements Runnable {

        private Integer number;

        private Producer(Integer number){
            this.number=number;
        }

        @Override
        public void run() {
            /*执行循环体*/

                System.out.println(Thread.currentThread().getName()+"将数据推送为%d"+number);
                try {
                    queues.put(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }




    static class Consumer implements Runnable{

        @Override
        public void run() {

            try {
                Integer number = queues.take();
                System.out.println(Thread.currentThread().getName()+"将要消费数据"+number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }






}
