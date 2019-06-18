package com.afei.service.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author afei
 *
 * @describe jdk动态代理
 *
 */
public class JDKProxyImpl implements InvocationHandler{



    private Object target;


    public JDKProxyImpl(){
        super();
    }


    public JDKProxyImpl(Object target){
        super();
        this.target=target;
    }




    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if("getName".equals(method.getName())){
            System.out.println("----before--" +method.getName()+"----");
            Object obj = method.invoke(target, args);

            System.out.println("-----obj--"+obj);
            System.out.println("----after--" +method.getName()+"----");
            return obj;

        }else {

            // 调用真实对象的方法
            Object othObj = method.invoke(target, args);
            return othObj;

        }

    }
}
