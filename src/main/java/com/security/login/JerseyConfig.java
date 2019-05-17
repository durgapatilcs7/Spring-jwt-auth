package com.security.login;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.security.login.config.CORSFilter;

@Component
public class JerseyConfig extends ResourceConfig {
   public JerseyConfig() {
	  //register(CORSFilter.class);
	  packages("com.security.login.controller");
   }
} 