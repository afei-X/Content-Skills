package com.afei.concurrency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @apiNote 进行volatile 的用例测试
 * @author gongxiangfei
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class volatileTest {



    AtomicInteger i=new AtomicInteger(0);


    volatile Integer k=10;


    @Test
    public  void  test()throws Exception{


        for (int j = 0; j < 1000; j++) {

            new Thread(){
                public void run(){

                    i.incrementAndGet();

                };
                }.start();
        }

        System.out.println(i);


    }




    @Test
    public  void  test1()throws Exception{

        for (int j = 0; j < 1000; j++) {

            new Thread(){
                public void run(){
                    synchronized (k){

                        k++;
                    }
                };
            }.start();
        }

        System.out.println(k);

    }



}
