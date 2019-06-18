package com.afei.pojo.dataStructure.list;

import com.afei.pojo.entity.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ListTest {



     public void test()throws Exception{

         List<Object> list = new ArrayList<>();

         list.add(1);
         list.add(2);

         /*1和2是等价的*/
         //1
         for (Object o : list) {

         }

         //2
         Iterator<Object> iterator = list.iterator();

         while (iterator.hasNext()){

             Object next = iterator.next();
         }




     }


    public void test1()throws Exception{

        List<Student> list = new ArrayList<>();

        Student s = new Student();
        s.setId(1);
        s.setName("lucy");
        s.setFieldName("lucy good");
        list.add(s);

        s.setId(2);
        s.setName("lucy");
        s.setFieldName("lucy not well");
        list.add(s);


        Map<String, List<Student>> collect = list.stream().collect(groupingBy(Student::getName));

        System.out.println(collect);


    }
}
