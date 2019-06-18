package com.afei.enumTest;

import com.afei.constant.DateEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gongxiangfei
 * @version 1.0
 * @describ  枚举测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class enumTest {

      @Test
      public void test()throws Exception{

          System.out.println(DateEnum.MONDAY.getValue());
          System.out.println(DateEnum.values().length);
          System.out.println(DateEnum.valueOf("MONDAY"));//MONDAY
          System.out.println(DateEnum.valueOf("FRIDAY"));//FRIDAY

      }
}



