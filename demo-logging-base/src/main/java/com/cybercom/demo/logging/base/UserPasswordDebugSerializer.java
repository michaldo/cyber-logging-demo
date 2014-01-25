package com.cybercom.demo.logging.base;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UserPasswordDebugSerializer extends JsonSerializer<UserPassword> {

	@Override
	public void serialize(UserPassword value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeString(value.getUser());
		
	}

	@Override
	public Class<UserPassword> handledType() {
		return UserPassword.class;
	}
	
	


}
