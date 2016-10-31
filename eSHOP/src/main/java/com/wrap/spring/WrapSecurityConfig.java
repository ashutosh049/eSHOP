package com.wrap.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ashu
 * 
 */
@Configuration
@ImportResource({ "classpath:wrapscecurityconfig.xml" })
public class WrapSecurityConfig {

	public WrapSecurityConfig() {
		super();
	}

}
