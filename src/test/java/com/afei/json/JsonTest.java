package com.afei.json;


import com.afei.pojo.entity.Student;
import com.afei.pojo.entity.StudentJsonEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTest {

      @Test
      public void test()throws Exception{

          Map<String, Object> map = new HashMap<>();

          map.put("first",1);
          map.put("second",2);






      }

       @Test
       public void test1()throws Exception{


          /*JSONarray和JSONObject都是继承于json 不过他们的实现不一样*/


           StudentJsonEntity student = new StudentJsonEntity();
           student.setId(1);
           student.setName("afei");
           System.out.println(student);

           String studentJson = JSON.toJSONString(student);
           System.out.println(studentJson);//{"id":1,"name":"afei"}


           /*将json串转化为hashmap类型*/
           Object jsonParse = JSONObject.parse(studentJson);
           System.out.println(jsonParse);//{"name":"afei","id":1}
           Map map= (Map)jsonParse;
           Object name = map.get("name");
           System.out.println(name);//afei


           JSONObject jsonObject = JSONObject.parseObject(studentJson);
           System.out.println(jsonObject);//{"name":"afei","id":1}
           Object id = jsonObject.get("id");
           System.out.println(id);//1


           Object jsonArrparse = JSONArray.parse(studentJson);
           System.out.println(jsonArrparse);//{"name":"afei","id":1}


           JSONArray arrName = jsonObject.getJSONArray("id");
           System.out.println(arrName);


       }


        @Test
         public void test2()throws Exception{

            Double seq = new Student().getSwq();

            Double s=seq;



        }
}
