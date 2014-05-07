package com.cybercom.demo.logging.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cybercom.demo.logging.base.MyScript;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MySpringBootConfiguration.class)

public class SpringBootTest {
   
   @Autowired MySpringBean myBean;

   @Test
   public void test() throws Exception {
      new MyScript().executeScript(myBean);
      
   }
   
   

}
