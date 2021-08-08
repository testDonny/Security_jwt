package com.example.testabc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter{
	
	/**
	 * 放行服務器
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.anyRequest().authenticated()
		.and().requestMatchers()
		.antMatchers("/user/**");
		
		
	}
	
	
}
