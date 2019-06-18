package com.afei.service.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyImpl implements MethodInterceptor {


    public Object target;

    public Object getInstance(Object target){
        this.target=target;

        Enhancer enhancer = new Enhancer();//创建加强器，用来创建动态代理类

        enhancer.setSuperclass(this.target.getClass()); //为增强器制定要代理的业务类（下面生成的代理类指定父类）

        //设置回调：对于代理类所有方法的调用，都会调用CallBack，而CallBack则需要实现intercept方法进行拦截

        enhancer.setCallback(this);

        return enhancer.create();
    }




    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib 调用前");

        Object obj = methodProxy.invokeSuper(o, objects);

        System.out.println("cglib 调用后");
        return obj;
    }






}
