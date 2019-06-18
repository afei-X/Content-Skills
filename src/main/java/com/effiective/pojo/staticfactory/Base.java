package com.effiective.pojo.staticfactory;

import java.math.BigDecimal;

public class Base {

    static {
        System.out.println("base");

    }
    protected Base(){
        System.out.println("base contruct");
    }



    public static void main(String[] args){

        BigDecimal b1 = new BigDecimal(1000);

    }

}
