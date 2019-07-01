package com.afei.pojo.designPattern.single;

import java.util.HashSet;
import java.util.Set;

public class Single {


    private static volatile Single instance=null;


    private  Single(){}


    public  static Single  getInstance(){
        if(instance==null){

            synchronized (Single.class){

                instance=new Single();

            }
        }

        return instance;
    }


    public  void test(){

        System.out.println(Thread.currentThread().getName()+"测试多线程下的单例操作");

    }


    public static void  main(String[] args){

        Set<Object> set = new HashSet<>();

        for (int i = 0; i <100000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    set.add(Single.getInstance());
                }
            }).start();

        }

        System.out.println(set.size());


    }






















}
