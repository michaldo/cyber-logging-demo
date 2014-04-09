package com.cybercom.demo.logging.ejb.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.cybercom.demo.logging.base.CoolToString;
import com.cybercom.demo.logging.base.Password;
import com.cybercom.demo.logging.base.UserPasswordDebugSerializer;
import com.cybercom.logging.core.DebugObjectMapper;
import com.cybercom.logging.core.MarkerProvider;
import com.cybercom.logging.core.ToStringSerializer;
import com.cybercom.logging.ejb.EjbEntryExitMethodLogger;

public class MyLoggedInterceptor  {
	
	private DebugObjectMapper mapper = new DebugObjectMapper();
	
	private List<Class<?>> excludedCustomType = new ArrayList<Class<?>>();
	
	  
	
	public MyLoggedInterceptor() {
		mapper.addJsonSerializer(new UserPasswordDebugSerializer());
		Class c = CoolToString.class;
		mapper.addJsonSerializer(new ToStringSerializer(c));
		excludedCustomType.add(Password.class);
	}

	@AroundInvoke
	public Object debug(InvocationContext ic) throws Exception, Throwable {
		return new EjbEntryExitMethodLogger(new CustomMarkerProvider(), mapper, excludedCustomType, true, ic).logEntryExit();
	}

	

}

class CustomMarkerProvider implements MarkerProvider {
	public String getMarker() {
		return "Custom";
	}
	
}


