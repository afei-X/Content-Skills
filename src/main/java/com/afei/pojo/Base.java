package com.afei.pojo;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

@Data
public class Base {

    private  Integer id;

    private String name;



    public Integer testGetId(){
        return id;
    }
}

