package com.cybercom.demo.logging.ejb;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cybercom.demo.logging.base.MyBean;
import com.cybercom.demo.logging.ejb.custom.MyEjbLogged;
import com.cybercom.logging.ejb.Logged;

@Stateless
@Logged

//uncomment to apply custom logger 
//@MyEjbLogged
public class MyEjbBean extends MyBean {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MyEjbBean.class);

	@Override
	public void errorThrowing() throws OutOfMemoryError {
		LOGGER.debug("In EJB world Error is not interceptable. Testing has no sense, so Error is not thrown");
	}


}
