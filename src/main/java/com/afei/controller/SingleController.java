package com.afei.controller;


import com.afei.pojo.designPattern.InstanceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类初始化 单列
 */
@RestController
public class SingleController {






    @GetMapping(value = "/single")
    public void testSingle(){

        InstanceFactory.getInstance();


    }


}