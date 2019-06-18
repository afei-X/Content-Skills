package com.effiective.pojo.staticfactory.static2;



/**
 * @author gongxiangfei
 * @describe static 修饰成员变量
 * @dataTime 2019-06-06
 */
public class Main {
    static int value = 33;


    /**
     * static 修饰成员变量，代表是类所有，在类初始化的时候创建一次，被所有对象共享
     */
    public static void main(String[] args) throws Exception{
        new Main().printValue();
    }

    private void printValue(){
        int value = 3;
        System.out.println(this.value);
    }
}
