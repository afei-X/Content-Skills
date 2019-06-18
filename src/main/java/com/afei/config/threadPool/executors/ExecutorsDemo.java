package com.afei.config.threadPool.executors;


import com.afei.config.threadPool.threadpool.ThreadPoolRunablePojo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gongxiangfei
 * @describe 使用executos创建线程池
 * @dataTime now();
 */
public class ExecutorsDemo {



    public static void main(String[] args){


        ThreadPoolRunablePojo pojo = new ThreadPoolRunablePojo();
        /*单个线程池*/
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(pojo);




    }


}
