package com.afei.reflect;

import com.afei.service.reflect.MethodReflect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReflectTest {

    private boolean b;

     @Test
     public void test()throws Exception{


         MethodReflect methodReflect = new MethodReflect();
         // 返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法
         //Method getReflect = MethodReflect.class.getMethod("getReflect");


         System.out.println(MethodReflect.class.getClassLoader());



         Method testFinal = MethodReflect.class.getMethod("testFinal");
         Object invokeFinal = testFinal.invoke(methodReflect);
         System.out.println(invokeFinal);

         Method testStatic = MethodReflect.class.getMethod("testStatic");
         Object invoke = testStatic.invoke(methodReflect);
         System.out.println(invoke);


         Method getPublic = MethodReflect.class.getMethod("getPublic");
         Object objGetPublic = getPublic.invoke(methodReflect);
         System.out.println(objGetPublic);


         // public final void java.lang.Object.wait() throws java.lang.InterruptedException
         // 这些对象反映此 Class 对象所表示的类或接口（包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法
         Method[] methods = MethodReflect.class.getMethods();
         for (Method method:methods){
             if(method.getName().equals("getReflect")){
                 System.out.println(method.invoke(methodReflect));
             }


         }

        //private java.lang.String com.afei.service.reflect.MethodReflect.getReflect()
         //回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法。
         Method getDeReflect = MethodReflect.class.getDeclaredMethod("getReflect");

         getDeReflect.setAccessible(true);
         Object invokeGetReflect = getDeReflect.invoke(methodReflect);
         System.out.println(invokeGetReflect);

         Method getDePublic = MethodReflect.class.getDeclaredMethod("getPublic");
         Object invokeGetPublic = getDePublic.invoke(methodReflect);
         System.out.println(invokeGetPublic);

         //返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
         Method[] declaredMethods = new MethodReflect().getClass().getDeclaredMethods();


     }
}
