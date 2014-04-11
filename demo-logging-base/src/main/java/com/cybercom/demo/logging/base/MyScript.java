package com.cybercom.demo.logging.base;

import javax.print.PrintException;


/**
 * The Class MyScript can execute all methods from IMyBean object
 */
public class MyScript {
	
	public void executeScript(IMyBean myBean) {
		
		myBean.voidMethod();

		myBean.incAgeBy1(new User("scott", 20));

		myBean.validate(new Password("tiger"));

		myBean.join(new User("scott", 20), new Password("tiger"));

		myBean.add(2, 2);

		myBean.iDontWantLogThisMethod(2, 2);
		
		try {
			myBean.exceptionThrowning();
		} catch (PrintException npe) {
			
		}
		
		try {
			myBean.errorThrowing();
		} catch (OutOfMemoryError oom) {
			
		}
		
		myBean.iWantToStringBeLogged();
		
		myBean.getNull(null);
		
	}
	

}
