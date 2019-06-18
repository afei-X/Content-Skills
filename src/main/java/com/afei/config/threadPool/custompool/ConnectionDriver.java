package com.afei.config.threadPool.custompool;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author gongxiangfei
 * @describe 自定义连接池驱动
 * @dataTime 2019-03-25 15:20:00
 */
public class ConnectionDriver {


    static class ConnectionHandler implements InvocationHandler{


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if("commit".equals(method.getName())){
                /*睡眠100毫秒*/
                TimeUnit.MILLISECONDS.sleep(100);

            }
            return null;
        }
    }

    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),
                new Class[]{Connection.class}, new ConnectionHandler() );
    }




}
