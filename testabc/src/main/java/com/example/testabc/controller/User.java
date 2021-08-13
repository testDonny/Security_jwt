package com.example.testabc.controller;

import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;


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
		
		return authentication.getPrincipal();
	}
	
	/**
	 * jwt 測試
	 * 可能會有版本衝突
	 * 找不到jar的問題
	 * @param 
	 * @return
	 */
	@RequestMapping("/testresults")
	public Object getCurrentUsers(Authentication authentication,HttpServletRequest request) {
		
		String name="Authorization";
					
		String head=request.getHeader(name);
		String token=head.substring(head.indexOf("bearer")+7);
		
		return Jwts.parser().setSigningKey("test_key".getBytes(StandardCharsets.UTF_8))
				.parseClaimsJws(token)
				.getBody();
	}
}
