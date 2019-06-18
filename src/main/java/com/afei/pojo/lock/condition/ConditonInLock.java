package com.afei.pojo.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gongxiangfei
 * @describe condition 接口 等待/通知模式
 * @dataTime now();
 */
public class ConditonInLock {
    
    
    
    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
        Condition condition =   lock.newCondition();
        try {
            condition.await();
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //public ConditionObject() { }


    }
    
    
}
