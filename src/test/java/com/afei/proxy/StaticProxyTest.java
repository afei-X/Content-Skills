package com.afei.proxy;

import com.afei.service.StaticService;
import com.afei.service.impl.StaticServiceImpl;
import com.afei.service.proxy.StaticProxyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticProxyTest {


     @Test
      public void test()throws Exception{

         StaticService target = new StaticServiceImpl();

         StaticProxyServiceImpl proxy = new StaticProxyServiceImpl(target);
         proxy.say();


     }


}
