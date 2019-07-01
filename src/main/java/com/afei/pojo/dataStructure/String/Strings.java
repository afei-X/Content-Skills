package com.afei.pojo.dataStructure.String;

public class Strings {

   /* public static void main(String[] args){


        String str="aa aa aaaa aa aaa a a a a a aaa a  aaa";

        long t1 = System.nanoTime();

        String[] strings = str.split(" ");
        int i=0;
        for (String string : strings) {
            if(string.length()>i){
                i=string.length();
            }

        }

        System.out.println(System.nanoTime()-t1);


    }*/

   public static void main(String[] args){

       String str="aa aa aaaa aa aaa a a a a a aaa a  aaa";
       long t1 = System.nanoTime();

       for (int i = 0; i <100 ; i++) {

           Thread thread = new Thread(new Runnable() {
               @Override
               public void run() {


                   char[] arr = str.toCharArray();
                   int len = 0;
                   int k = 0;
                   for (int i = 0; i < arr.length; i++) {
                       if (' ' == arr[i]) {
                           len = Math.max(i - k - 1, len);
                           k = i;
                       }
                   }
                   long t2 = System.nanoTime();

               }
           });

           thread.start();
           try {
               thread.join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }

       System.out.println(System.nanoTime()-t1);

   }



}
