package com.afei.thread;


import com.afei.pojo.thread.creatAndStart.ThreadExtends;
import com.afei.pojo.thread.creatAndStart.ThreadsImplements;

public class CreateThread {



    public  static void main (String[] args){

        /*继承的方式创建线程并且启动*/
        new ThreadExtends().start();

        /*通过实现的方式创建线程并且启动*/
        new Thread(new ThreadsImplements()).start();


    }


}
