package com.afei.controller.charset;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/charset")
public class CharsetController {


    @RequestMapping(value = "/question",method = RequestMethod.POST)
    public String answear(String name){

        System.out.println(name);
        return "你是🐷吗"+name;
    }






}
