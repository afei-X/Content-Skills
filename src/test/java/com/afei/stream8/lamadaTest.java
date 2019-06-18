package com.afei.stream8;


import com.afei.pojo.Base;
import com.afei.pojo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class lamadaTest {


     /**
      *list的lamada操作
      * @throws Exception
      */
     @Test
     public void testList()throws Exception{

        /*深入理解java的三大特性*/
         Base b=new Student();

         List<Object> objList = new ArrayList<>();

         List<Student> list = new ArrayList<>();
          for (int i = 0; i <2 ; i++) {
               Student s = new Student();
               s.setId(1);
               s.setFieldName("student 的字段赋值");
               list.add(s);
          }

          /*继承父类的字段是可以操作的，  但是私有话的方法是无法操作的*/
          list.forEach((student) -> {student.setFieldName("更改student的字段之后的值"); System.out.println(student.testGetId());
              System.out.println(student.getName());});
          list.forEach(student -> System.out.println(student.getId()));




          list.forEach(student -> objList.add(student));
          objList.forEach(o -> System.out.println(o));



     }


    /**
     * map 的lamada操作
     * @throws Exception
     */
      @Test
       public void testMap()throws Exception{

          Map<String, Object> map = new HashMap<>();

          for (int i = 0; i <2 ; i++) {
              map.put("1","1");
              map.put("2","2");
          }

          map.forEach((s, o) -> {
              if(s.contains("1")){
                  System.out.println(o);
              }
              if(s.contains("2")){
                  int i = s.compareTo("1");
                  System.out.println(i);
              }


          });
       }


    /**
     * filter 过滤器
     * stream lamada 表达式
     * @throws Exception
     */
    @Test
    public void test()throws Exception{

        List<String> s = Arrays.asList(new String[]{"1", "2", "3", "4", "2", ""});

        List<String> list = s.stream().filter(s1 -> !s1.equals("1")).collect(Collectors.toList());

        System.out.println(list);
    }


    /**
     * 类名：：方法名 java.util.Function
     * @throws Exception
     */
    @Test
    public void testNew()throws Exception{
        Student student = new Student();
        student.setFieldName("测试新特性");

        Function<Student, String> getFieldName = Student::getFieldName;
        String s = getFieldName.apply(student);
        System.out.println(s);


        //System.out.println(Student::getFieldName);

    }

    /**
     * 测试 lamada map方法
     * @throws Exception
     */

     @Test
     public void testLamadaMap()throws Exception{

         List<Student> students = new ArrayList<>();
         for (int i = 0; i <2 ; i++) {
             Student student = new Student();
             student.setFieldName("索隆");
             students.add(student);
         }

         List<String> lists = students.stream()
                 /*过滤器里面是不能为空的*/
                 .filter(student -> student.getFieldName() != "乔巴")
                 /*map  里面是要集合数据 student:: getName 是function 。  */
                 .map(Student::getName)
                 .collect(Collectors.toList());

         System.out.println(lists);

     }


     /**
      * lamada的方式创建线程
      */
      @Test
      public void testCreateThread()throws Exception{

         new Thread(() -> System.out.println("创建线程")).start();


      }

}
