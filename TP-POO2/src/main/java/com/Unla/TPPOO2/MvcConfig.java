package com.Unla.TPPOO2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	@Bean //Para poder ser inyectado en cualquier otra clase que se necesite
	public BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();	
	}

}
