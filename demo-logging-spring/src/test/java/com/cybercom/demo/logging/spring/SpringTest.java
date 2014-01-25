package com.cybercom.demo.logging.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cybercom.demo.logging.base.MyScript;

public class SpringTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-beans.xml");

		MySpringBean myBean = (MySpringBean) context.getBean("mySpringBean");
		new MyScript().executeScript(myBean);
		myBean.addSpringSpecific(3, 4);
	}

}
