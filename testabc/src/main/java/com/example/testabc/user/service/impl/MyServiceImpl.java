package com.example.testabc.user.service.impl;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.testabc.user.service.MyService;
import com.mongodb.client.model.Collation;

@Service
public class MyServiceImpl implements MyService{

	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		
		//獲得物件
		Object obj=authentication.getPrincipal();
		
		//判斷物件是否屬於UserDetails
		if(obj instanceof UserDetails) {
			UserDetails userDetails=
			(UserDetails) obj;
		Collection<? extends GrantedAuthority> authorities
		=userDetails.getAuthorities();	
		
			//判斷請求的uri是否在權限裡
		return authorities.contains(new SimpleGrantedAuthority(request.getRequestURI()) );
		}
		
		return false;
	}


}
