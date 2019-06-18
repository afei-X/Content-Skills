package com.afei.pojo.dataStructure.String;

public class StringTest {




     public void test()throws Exception {

         String url="http://baidu.com";

         String str = String.format(url, "\r 1234");//使用指定的格式字符串和参数返回一个格式化字符串。


         System.out.println(str);


     }
}
