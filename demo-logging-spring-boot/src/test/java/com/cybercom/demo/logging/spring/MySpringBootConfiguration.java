package com.cybercom.demo.logging.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cybercom.demo.logging.base.CoolToString;
import com.cybercom.demo.logging.base.Password;
import com.cybercom.demo.logging.base.UserPasswordDebugSerializer;
import com.cybercom.logging.core.ToStringSerializer;
import com.cybercom.logging.spring.LoggedSpringAspect;
import com.fasterxml.jackson.databind.JsonSerializer;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)

public class MySpringBootConfiguration {
   
   public static void main(String[] args) throws Exception {
      SpringApplication.run(MySpringBootConfiguration.class, args);
   }
   
   @Bean
   LoggedSpringAspect loggingInterceptor() throws ClassNotFoundException {
      LoggedSpringAspect logging = new LoggedSpringAspect();
      List<Class<?>> exludedFromLogging = new ArrayList<Class<?>>();
      exludedFromLogging.add(Password.class);
      logging.setExcludedCustomTypes(exludedFromLogging);
      List<JsonSerializer<?>> serializers = new ArrayList<JsonSerializer<?>>();
      serializers.add(new UserPasswordDebugSerializer());
      Class<?> c = CoolToString.class;
      ToStringSerializer toStringSerializer = new ToStringSerializer((Class<Object>) c);
      
      serializers.add(toStringSerializer);
      logging.setSerializers(serializers);
      return logging;
   }


}
