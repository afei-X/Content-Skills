package com.afei.thread;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SynchronizedTest {


    public  synchronized  void done(){
        System.out.println("synchronized 作用于方法上");

    }

    public  void done1(){
        synchronized (this){

            System.out.println("synchronized 作用于代码块上");
        }

    }






     @Test
     public void test()throws Exception{


         done();
         done1();


     }



}
