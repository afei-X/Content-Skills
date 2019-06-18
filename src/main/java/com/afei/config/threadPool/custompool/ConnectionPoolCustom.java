package com.afei.config.threadPool.custompool;


import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author gongxiangfei
 * @describe 自定义连接池
 * @dataTime 2019-03-25 15:20:00
 */
public class ConnectionPoolCustom {

    /*连接池对象*/
    private LinkedList<Connection> pool = new LinkedList<>();


    /*设置连接池的大小*/
    ConnectionPoolCustom(int initialSize){
        if(initialSize>0){
            for (int i = 0; i < initialSize; i++) {

                pool.addLast(ConnectionDriver.createConnection());

            }
        }
    }

    public void releaseConnection(Connection connection){

        if(connection!=null){
            synchronized (pool){
                //连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fectchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            // 完全超时
            if(mills<0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                /*移除第一个*/
                return  pool.removeFirst();
            }else{

                long future = System.currentTimeMillis() + mills;
                long remaining = mills;

                /*当双向链表为空 && 等待时间>0*/
                while (pool.isEmpty() && remaining>0){

                    pool.wait(remaining);
                    /*当前剩余的时长*/
                    remaining=future-System.currentTimeMillis();

                }

                Connection result=null;

                /*不为空*/
                if(!pool.isEmpty()){

                    result = pool.removeFirst();
                }
                return  result;

            }

        }
    }





}
