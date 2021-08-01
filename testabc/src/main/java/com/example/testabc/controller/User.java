package com.example.testabc.controller;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value="/user")
@RestController
public class User {


	/**
	 * 獲取當前用戶
	 * @param authentication
	 * @return
	 */
	
	@RequestMapping("/testresult")
	public Object getCurrentUser(Authentication authentication) {
		
		Object abc=authentication.getPrincipal();
		System.out.println(abc);
		System.out.println(authentication.getCredentials().toString());
		
		
		return authentication.getPrincipal();
	}
}
