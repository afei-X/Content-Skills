package com.effiective.pojo.staticfactory.static2;


import com.effiective.pojo.staticfactory.Base;

/**
 * @author gongxiangfei
 * @describe static 修饰类
 * @dataTime 2019-06-06
 */
public class Test  extends Base {


    static {
        System.out.println("test");
    }

   private Test(){
        System.out.println("test contruct");
    }


    public static void main(String[] args){


        new Test();
    }










}
