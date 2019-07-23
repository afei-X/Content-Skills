package com.afei.pojo.wrapper;

import com.afei.pojo.entity.Animal;
import com.afei.pojo.entity.User;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author gongxiangfei
 * @describe 包装类的装箱和拆箱
 * @dataTime 1019-06-04 17：57：00
 */
public class WrapperDemo {


    public static void main(String[] args) {


        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));


        Random random = new Random();
        BigInteger integer = BigInteger.probablePrime(3, random);
        System.out.println(integer.toString());
        integer = BigInteger.probablePrime(3, random);
        System.out.println(integer);




    }

}
