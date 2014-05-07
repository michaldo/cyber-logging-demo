package com.cybercom.demo.logging.cglib;


import org.junit.Test;

import com.cybercom.demo.logging.base.MyBean;
import com.cybercom.demo.logging.base.MyScript;
import com.cybercom.logging.cglib.LoggedCglibProxy;

public class LoggingCglibDemoTest {

	@Test
	public void test() {
		MyBean myBean = LoggedCglibProxy.createProxy(new MyBean());
		new MyScript().executeScript(myBean);
	}

}
