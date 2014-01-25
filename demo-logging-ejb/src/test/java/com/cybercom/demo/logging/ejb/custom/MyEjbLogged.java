package com.cybercom.demo.logging.ejb.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.Interceptors;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Interceptors(MyLoggedInterceptor.class)
public @interface MyEjbLogged {

}
