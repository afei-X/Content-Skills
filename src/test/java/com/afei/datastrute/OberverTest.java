package com.afei.datastrute;

import com.afei.pojo.designPattern.oberver.HostSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OberverTest {





    @Autowired
    private HostSubject hostSubject;

     @Test
     public void test()throws Exception{

         hostSubject.publish();

         System.out.println("一部吗");

     }
}
