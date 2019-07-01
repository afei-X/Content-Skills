package com.afei.pojo.dataStructure.String;

public class StringTest {




     public static void main(String[] args){



       /* String url="http://baidu.com";
        String str = String.format(url, "\r 1234");//使用指定的格式字符串和参数返回一个格式化字符串。
        System.out.println(str);*/

        String str="aa aa aaaa aa aaa a a a a a aaa a  aaa";


         long t1 = System.nanoTime();
         int len = 0;
         while(true){
             int k = str.indexOf(" ");
             if(k < 0){
                 break;
             }
             if(len < str.substring(0,k).length() ){
                 len = str.substring(0,k).length();
             }
             str = str.substring(k+1);
         }
         long t2 = System.nanoTime();
         System.out.println("getMaxSubLen1不包含空格的最大子串长度："+len+"---time："+(t2-t1));






     }


}
