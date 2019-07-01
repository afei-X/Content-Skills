package com.afei.pojo.designPattern.single;

import org.springframework.stereotype.Component;

/**
 * @author gongxiangfei
 * @describe 基于类加载实现单例
 */
public class InstanceFactory {

    private static class InstaceHolder{

       public static Instance instance= new Instance();
    };

    public static Instance getInstance(){
        return InstaceHolder.instance;
    }

    static class Instance{
        public  Instance(){
        }
    }
}
