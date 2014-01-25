package com.cybercom.demo.logging.spring;

import org.springframework.stereotype.Component;

import com.cybercom.demo.logging.base.MyBean;
import com.cybercom.logging.spring.Logged;

@Component
@Logged
public class MySpringBean extends MyBean {
	
	public int addSpringSpecific(int a, int b) {
		return a + b;
	}

}
