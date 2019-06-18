package com.afei.pojo.dataStructure.map;



import java.math.BigDecimal;
import java.util.*;

public class MapTest {

    public void test()throws Exception{
        Map<Object, Object> map = new HashMap<>();
        /*结论： map是的key是可以存放null*/
        map.put("",null);
        map.put(null,null);
        System.out.println(map);

        Set<Map.Entry<Object, Object>> entries = map.entrySet();

        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println(next.getKey()+"."+next.getValue());
        }


    }


     public void test2()throws Exception{


         Map<String, Object> map = new HashMap<>();
         map.put("key",1);
         map.put("key1",2);

         /*循环遍历hashmap的另一种方式*/
         Set<Map.Entry<String, Object>> entries = map.entrySet();//所有
         entries.forEach(objectObjectEntry ->
            {

                System.out.println(objectObjectEntry.getKey());
                System.out.println(objectObjectEntry.getValue());
         });

         Iterator<Map.Entry<String, Object>> iterator = entries.iterator();



         Set<String> objects = map.keySet();//keys
         objects.forEach(o -> System.out.println(o));

         Collection<Object> values = map.values();//values
         values.forEach(o -> System.out.println(o));


         Object obj = map.get("key");
         System.out.println(obj);


     }

    /**
     * 转义符
     * 单个转义符使用是没有意义的  好结合进行使用 详情百度
     */
      public void test1()throws Exception{

        String s ="sgg\12234";
         System.out.println(s);

         s="\"";
         System.out.println(s);

         s="sgeg\\fdg223";
         System.out.println(s);


      }

    public void test3()throws Exception{

        Map<String, BigDecimal> map = new HashMap<>();
        map.put("key",new BigDecimal(2));
        map.put("key1",new BigDecimal(4));

        map.forEach((k, v) -> {

            BigDecimal newV=v.divide(new BigDecimal(2));
            map.put(k,newV);
        });

        System.out.println(map);

    }



















}
