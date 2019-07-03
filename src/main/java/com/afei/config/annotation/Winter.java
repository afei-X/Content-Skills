package com.afei.config.annotation;

import com.afei.pojo.entity.Student;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gongxiangfei
 * @describe 自定义注解 的使用
 */
@Data
public class Winter {


    @FirstAnnotation(id = "1",name = "temperature")
    private String temperature;


   /* @FirstAnnotation(id = "2",name="code",value = "boolean code")
    private Boolean code;*/


    /**
     * 通过反射的方式获取注解
     */
    public static void main (String[] args) throws NoSuchFieldException, IllegalAccessException {


        Winter winter = new Winter();
        Field[] fields = winter.getClass().getDeclaredFields();

        List<Winter> lists = new ArrayList<>();



        for (Field field : fields) {

            FirstAnnotation annotation = field.getAnnotation(FirstAnnotation.class);

            System.out.println(annotation.add());
            /*field.setAccessible(true);
            field.set(winter,"1234");

            lists.add(winter);*/
        }

        /*lists.forEach(s -> {

            for (Field field : fields) {

                FirstAnnotation annotation = field.getAnnotation(FirstAnnotation.class);
                String id = annotation.id();

                try {
                    Object o = field.get(s);
                    System.out.println(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        });*/

    }
}
