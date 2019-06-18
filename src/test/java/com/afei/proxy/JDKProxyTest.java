package com.afei.proxy;

import com.afei.service.UserService;
import com.afei.service.impl.UserServiceImpl;
import com.afei.service.proxy.JDKProxyImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyTest {



      public  static void main (String[] args)throws Exception{


          System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
          UserService userService = new UserServiceImpl();
          System.out.println(userService.getClass());//class com.afei.service.impl.UserServiceImpl
          System.out.println(userService.toString());//com.afei.service.impl.UserServiceImpl@21a06946
          System.out.println(userService.hashCode());//858507952

         InvocationHandler jdkProxy = new JDKProxyImpl(userService);

         /*UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                 userService.getClass().getInterfaces(), jdkProxy);*/

          /**
           *
           * @param   loader the class loader to define the proxy class   指定代理的类加载器
           * @param   interfaces the list of interfaces for the proxy class to implement   代理类实现的接口列表
           * @param   h the invocation handler to dispatch method 调用处理程序的调度方法
           *
           */
          UserService userServiceProxy = (UserService)Proxy.newProxyInstance(UserService.class.getClassLoader(),
                  new Class[]{UserService.class}, jdkProxy);


          /*字节码对象才是真正的对象*/
          System.out.println(userServiceProxy.getClass());//class com.sun.proxy.$Proxy0
          System.out.println(userServiceProxy);//com.afei.service.impl.UserServiceImpl@21a06946
          System.out.println(userServiceProxy.toString());//com.afei.service.impl.UserServiceImpl@21a06946
          System.out.println(userServiceProxy.hashCode());//858507952


          /*动态代理 invoke方法 先走动态代理的增强方法，然后再进行自己的方法*/
          System.out.println(userServiceProxy.getName(2));
          System.out.println(userServiceProxy.getAge(2));

          UserServiceImpl u=(UserServiceImpl)userServiceProxy;


     }

}
