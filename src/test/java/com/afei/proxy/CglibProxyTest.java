package com.afei.proxy;

import com.afei.pojo.entity.User;
import com.afei.service.proxy.CglibProxyImpl;

public class CglibProxyTest {


    public static void main(String[] args){

        User user = new User();

        User instance = (User)new CglibProxyImpl().getInstance(user);
        instance.smile();

    }
}


