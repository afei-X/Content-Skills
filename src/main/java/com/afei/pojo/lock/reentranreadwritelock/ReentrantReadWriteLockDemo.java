package com.afei.pojo.lock.reentranreadwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author gongxiangfei
 * @describe 读写锁
 * @dataTime 2019-04-17
 */
public class ReentrantReadWriteLockDemo {

    private static int i=0;


    public static void main(String[] args){



        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Lock writeLock = lock.writeLock();
        Lock readLock = lock.readLock();

        //read(readLock);
        write(writeLock);

        System.out.println(i);


    }


    private static void read(Lock readLock){

        /*读是共享锁*/
        readLock.lock();
        i++;
        readLock.unlock();
    }

    private static void write(Lock writeLock){

        writeLock.lock();
        i--;
        writeLock.unlock();

    }


}
