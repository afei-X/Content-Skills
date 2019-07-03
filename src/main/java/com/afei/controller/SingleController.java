package com.afei.controller;


import com.afei.pojo.designPattern.single.InstanceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试类初始化 单列
 */
@RestController
public class SingleController {


    @GetMapping(value = "/single")
    public void testSingle(String name, HttpServletRequest request){


        InstanceFactory.getInstance();


    }


}
