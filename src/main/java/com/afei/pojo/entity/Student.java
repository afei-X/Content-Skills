package com.afei.pojo.entity;

import com.afei.pojo.Base;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class Student extends Base implements Serializable {


    private String fieldName;

    private Double swq;





    public static void main(String[] args){


        JSONObject jsonObject = new JSONObject();
        Object key = jsonObject.getOrDefault("key", "");


    }



}

