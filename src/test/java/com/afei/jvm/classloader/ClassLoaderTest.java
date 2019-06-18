package com.afei.jvm.classloader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gongxiangfei
 * @version 1.0
 * @describ 类加载的测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassLoaderTest {


    /**
     *验证类加载的委托性和单一性
     */
    @Test
    public void test()throws Exception{

        System.out.println("classloader"+this.getClass().getClassLoader());//该类由application类加载器加载

        /*类只能被加载一次  其他类加载器再次去加载的时候 会出现ClassNotFoundException*/
        Class.forName("com.afei.jvm.classloader.ClassLoaderTest",true,this.getClass().getClassLoader().getParent());
    }








}
