package com.afei.service.proxy;

import com.afei.service.StaticService;



/**
 * @author  afei
 *
 *@describe  静态代理
 *
 */
public class StaticProxyServiceImpl implements StaticService {

    /**
     * 目标对象
     */
    private StaticService target;

    public  StaticProxyServiceImpl (StaticService target){

        this.target=target;
    }




    @Override
    public void say() {

        System.out.println("开始打印日志");
        target.say();
        System.out.println("任务完成");
    }
}
