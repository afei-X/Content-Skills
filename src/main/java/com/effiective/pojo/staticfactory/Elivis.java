package com.effiective.pojo.staticfactory;


/**
 * @author gongxiangfei
 * @describe 静态工厂  和设计模式中的静态共享不一样
 * @dataTime 2019-06-05 18：55：00
 */
public class Elivis {

    private static  Elivis INSTANCE=new Elivis();


    private Elivis(){}





    public static void main(String[] args){


        Elivis instance = Elivis.INSTANCE;
        Elivis elivis = Elivis.INSTANCE;


        System.out.println(instance==elivis);



    }
}
