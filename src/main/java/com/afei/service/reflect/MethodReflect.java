package com.afei.service.reflect;

public class MethodReflect{


    private String getReflect(){
        return "私有方法";
    }

    public  String getPublic(){

        return "共有方法";
    }


    public final String testFinal(){
        return "final 修饰的方法";
    }

    public  static void testStatic(){
        System.out.println("static 修饰的方法");
    }
}
