package com.cybercom.demo.logging.base;

import javax.print.PrintException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cybercom.logging.core.NotLogged;

public class MyBean implements IMyBean {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MyBean.class);

	public void voidMethod(){
		LOGGER.debug("I expect entry/exit of this method is logged");
	}
	
	public User incAgeBy1(User user) {
		LOGGER.debug("I expect entry/exit of this method is logged");
		user.setAge(user.getAge() + 1);
		return user;
	}
	
	public Password validate(Password password) {
		LOGGER.debug("I expect Password is excluded from logging, as argument and as result");
		LOGGER.debug("(Not applicable for default conifguration for proxy and ejb");
		return password;
	}
	
	public UserPassword join(User user, Password password) {
		LOGGER.debug("I expect Password is excluded from logging and UserPassword shows name only");
		LOGGER.debug("(Not applicable for default conifguration for proxy and ejb");
		return new UserPassword(user.getName(), password.getPassword());
	}
	
	public int add(int a, @NotLogged int b) {
		LOGGER.debug("I expect only a is logged (one param)");
		return a + b;
	}

	@NotLogged
	public int iDontWantLogThisMethod(int a, @NotLogged int b) {
		LOGGER.debug("I expect entry/exit iDontWantLogThisMethod(...) is not logged");
		return a + b;
	}
	
	public void exceptionThrowning() throws PrintException {
		throw new PrintException("Fake exception");
	}
	
	public void errorThrowing() throws OutOfMemoryError {
		throw new OutOfMemoryError("Fake error");
	}
	
	public CoolToString iWantToStringBeLogged() {
		LOGGER.debug("toString() is not used for default conifguration for proxy and ejb");
		return new CoolToString("toString is well implemented and I want use it for logging");
	}

   public Object getNull(Object o) {
      return null;
   }

}
