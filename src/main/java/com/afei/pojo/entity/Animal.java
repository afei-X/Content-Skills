package com.afei.pojo.entity;

import lombok.Data;

import java.util.Objects;
/**
 * @author gongxiangfei
 * @describe 验证hashcode和equals
 * @dataTime 晚上，我还在努力
 */

public class Animal {

    private String id;

    private Animal(){

    }

    private Animal(String id){

        this.id=id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

   /* @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/


    public static void main(String[] args){

        Animal a1 = new Animal("1");
        Animal a2 = new Animal("1");

        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.toString());
        System.out.println(a2.toString());



    }

}
