package com.afei.pojo.dataStructure.String;


/**
 * @author gongxiangfei
 * @describe string
 * @dataTime now();
 */
public class StringDemo {


    public static void main(String[] args){

        String a="vvv";
        String b = new String("vvv");
        String c ="vvv";

        System.out.println(a.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a==b);//false
        System.out.println(a==c);//true

    }
}
