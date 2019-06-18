package com.afei.service.impl;


import com.afei.service.UserService;

/**
 * @author  afei
 *
 * 实例接口的实现
 *
 */
public class UserServiceImpl implements UserService{


    @Override
    public String getName(int id) {
        System.out.println("根据id获取name");
        return "afei";
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("根据id获取age");
        return 23;
    }
}
