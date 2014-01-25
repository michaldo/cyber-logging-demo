package com.cybercom.demo.logging.base;

import javax.print.PrintException;

import com.cybercom.logging.core.NotLogged;

/**
 * The interface IMyBean is required by Java proxy and is created to demonstrate 
 * logging entry/exit for non-Spring and non-EJB classes
 */
public interface IMyBean {
	
	void voidMethod();
	
	User incAgeBy1(User user);
	
	Password validate(Password password) ;
	
	UserPassword join(User user, Password password);
	
	int add(int a, @NotLogged int b);

	@NotLogged
	int iDontWantLogThisMethod(int a, int b);
	
	void exceptionThrowning() throws PrintException;
	
	void errorThrowing() throws OutOfMemoryError ;
	
	CoolToString iWantToStringBeLogged();


}