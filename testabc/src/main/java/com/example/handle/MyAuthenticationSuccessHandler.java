package com.example.handle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	private String url;
		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		User user=(User)authentication.getPrincipal();
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAuthorities());
		System.out.println(request.getRemoteAddr());
		
		response.sendRedirect(url);
	}

}
