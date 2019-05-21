package com.example.demo.version;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;

@Configuration
public class WebMvcRegistrationsConfig implements  WebMvcRegistrations  {
	@Override   
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
		return new ApiRequestMappingHandlerMapping();  
		}
	
}
