package com.afei.config.threadPool.custompool;


import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gongxiangfei
 * @describe 测试
 * @dataTime now();
 */
public class ConnectionPoolTest {


    static ConnectionPoolCustom pool= new ConnectionPoolCustom(10);

    // 保证所有ConnectionRunner 能够同时开始
    static CountDownLatch start= new CountDownLatch(1);
    
    static CountDownLatch end;
    
    public static void main(String[] args) throws  Exception{
        
        int threadCount=10;

        end= new CountDownLatch(threadCount);
    
        int count=20;

        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i <threadCount; i++) {
            Thread connectionRunnerThread = new Thread(new ConnectionRunner(count, got, notGot),
                    "ConnectionRunnerThread");
            connectionRunnerThread.start();

        }
        start.countDown();
        end.await();

        System.out.println("total invoke " + threadCount * count);
        System.out.println("got connection " + got);
        System.out.println(" notGot connection " + notGot);
    }
    
    
    
    static  class ConnectionRunner implements  Runnable{
        
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {

            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            while (count>0){

                try {
                    Connection connection = pool.fectchConnection(1000);
                    if(connection!=null){

                        try {

                            Statement statement = connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        notGot.incrementAndGet();
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count --;
                }

            }

            end.countDown();

        }
    }
    


}
