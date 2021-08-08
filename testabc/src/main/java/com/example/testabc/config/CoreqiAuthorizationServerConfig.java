//package com.example.testabc.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
//
///**
// * 不實作會報錯
// * @author user1
// *
// */
//@Configuration
//@EnableAuthorizationServer  //Open the authentication Server
//public class CoreqiAuthorizationServerConfig implements AuthorizationServerConfigurer {
//
//	
//	private PasswordEncoder passwordEncoder;
//	
//	String url="https://tw.yahoo.com/";
//	
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//	}
//
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//}
