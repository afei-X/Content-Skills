package com.afei.constant;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * 枚举类
 * @version 1.0
 * @author gongxiangfei
 */
public enum DateEnum {

    MONDAY(1,"星期一"),FRIDAY(2,"星期二");


    DateEnum(String value) {
        this.value = value;
    }

    DateEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    private Integer id;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
