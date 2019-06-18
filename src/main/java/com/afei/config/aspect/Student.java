package com.afei.config.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/5/9.
 */

@Aspect
//@Component
@Configuration
public class Student {

    @Pointcut("execution(* com.afei.config.aspect.StudentServiceImpl.show(..))")
    public void show(){}


    @Before("show()")
    public  void marchArena(){
        System.out.println("进入表演会场");
    }


    @After("show()")
    public void showTime(){
        System.out.println("表演结束");
    }

    /**
     * 当切点方法调用抛出异常的时候，才会执行这句话
     */
    @AfterThrowing("show()")
    public void badTime(){
        System.out.println("演出怎么样呢？");
    }


   /* @Around("show()")
    public void  aroundAdvice(ProceedingJoinPoint pj) throws Throwable {

        pj.proceed();


    }*/





}
