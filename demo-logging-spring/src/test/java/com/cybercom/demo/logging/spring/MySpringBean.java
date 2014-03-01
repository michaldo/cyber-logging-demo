package com.cybercom.demo.logging.spring;

import javax.print.PrintException;

import org.springframework.stereotype.Component;

import com.cybercom.demo.logging.base.CoolToString;
import com.cybercom.demo.logging.base.MyBean;
import com.cybercom.demo.logging.base.Password;
import com.cybercom.demo.logging.base.User;
import com.cybercom.demo.logging.base.UserPassword;
import com.cybercom.logging.core.NotLogged;
import com.cybercom.logging.spring.Logged;

/**
 * The Class MySpringBean overwrites all superclass methods.   
 * It is stupid, i don't know how write pointcut which covers public methods in superclass
 * of class annotated by @Logged
 * Theoretically, '@target' works but it cause MVC application startup failure.
 * That reason why '@within' applied which covers only public methods within current class
 * 
 * It should not be a problem in real world. Possible workaround in annotate base class
 * with *.spring.Logged
 * 
 * I didn't apply workaround in demo because I wanted MyBean free of Spring specific annotations
 */
@Component
@Logged
public class MySpringBean extends MyBean {

   @Override
   public void voidMethod() {
      // TODO Auto-generated method stub
      super.voidMethod();
   }

   @Override
   public User incAgeBy1(User user) {
      // TODO Auto-generated method stub
      return super.incAgeBy1(user);
   }

   @Override
   public Password validate(Password password) {
      // TODO Auto-generated method stub
      return super.validate(password);
   }

   @Override
   public UserPassword join(User user, Password password) {
      // TODO Auto-generated method stub
      return super.join(user, password);
   }

   @Override
   public int add(int a, @NotLogged int b) {
      // TODO Auto-generated method stub
      return super.add(a, b);
   }

   @Override
   @NotLogged
   public int iDontWantLogThisMethod(int a, @NotLogged int b) {
      // TODO Auto-generated method stub
      return super.iDontWantLogThisMethod(a, b);
   }

   @Override
   public void exceptionThrowning() throws PrintException {
      // TODO Auto-generated method stub
      super.exceptionThrowning();
   }

   @Override
   public void errorThrowing() throws OutOfMemoryError {
      // TODO Auto-generated method stub
      super.errorThrowing();
   }

   @Override
   public CoolToString iWantToStringBeLogged() {
      // TODO Auto-generated method stub
      return super.iWantToStringBeLogged();
   }
	


}
