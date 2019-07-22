package com.afei.pojo.thread.threadLocal;

import com.afei.pojo.entity.Student;

/**
 * threadLocal的使用 ---->Thread
 */
public class ThreadLocalDemo {



    public static final ThreadLocal<Student> CURRENT_THREAD_LOCAL =new ThreadLocal<>();



    public static  void main(String[] args){

        Student s = new Student();
        s.setId(10010);
        s.setName("wo shi a fei ");
        s.setFieldName("this is a fieldName");
        CURRENT_THREAD_LOCAL.set(s);


        Student student = CURRENT_THREAD_LOCAL.get();

        System.out.println(student.getName()+","+student.getFieldName()+"."+student.getId());


    }












}
