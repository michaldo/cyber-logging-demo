package com.cybercom.demo.logging.proxy;


import org.junit.Test;

import com.cybercom.demo.logging.base.IMyBean;
import com.cybercom.demo.logging.base.MyBean;
import com.cybercom.demo.logging.base.MyScript;
import com.cybercom.logging.core.proxy.LoggedProxy;

public class LoggingProxyDemoTest {

	@Test
	public void test() {
		IMyBean myBean = LoggedProxy.createProxy(new MyBean(), IMyBean.class);
		new MyScript().executeScript(myBean);
	}

}
