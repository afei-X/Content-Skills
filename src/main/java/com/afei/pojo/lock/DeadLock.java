package com.afei.pojo.lock;


import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author gongxiangfei
 * @describe 死锁问题
 * @dataTime now();
 */
public class DeadLock {

    private static volatile String A="A";
    private static volatile String B="B";


    public static void main(String[] args){
        BigDecimal bigDecimal = new BigDecimal(49.01);
        BigDecimal scale = bigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP);
        BigDecimal divide = bigDecimal.divide(new BigDecimal(1), 0, BigDecimal.ROUND_HALF_UP);
        System.out.println(scale);
        System.out.println(divide);


        new DeadLock().deadLock();



    }

    private void deadLock(){

        Thread ta = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {

                    synchronized (B) {

                        try {
                            //TimeUnit.MILLISECONDS.sleep(5);
                            System.out.println("线程ta执行完成");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {

                            B.notifyAll();
                        }
                    }


                }


            }
        });

        Thread tb = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (B) {

                    try {
                        //TimeUnit.MILLISECONDS.sleep(5);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    synchronized (A) {

                        System.out.println("线程tb执行完成");
                    }

                }


            }
        });

        ta.start();
        tb.start();

    }







}
