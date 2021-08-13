package com.example.testabc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.example.testabc.user.dao.UsersRepositorys;
import com.example.testabc.user.service.UserDetailsServiceImpl;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	String url = "https://tw.yahoo.com/";
	String url1 = "http://localhost:10084/login";

	@Autowired
	private UsersRepositorys usersRepositorys;

	@Autowired
	private UserDetailsServiceImpl userService;

	@Autowired
	private AuthenticationManager authenticationManager;

//	@Autowired
//	@Qualifier("redisTokenStore")
//	private TokenStore tokenStore;

	@Autowired
	private JwtTokenEnhancer jwtTokenEnhancer;

	
	@Autowired
	@Qualifier("jwtTokenStore")
	private TokenStore tokenStore;

	/**
	 * 會影響配置
	 */
	
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	
	//
	
	/**
	 * 加密演算模式
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 使用密碼模式 內存方法
	 */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endopints) throws Exception{
//    	endopints.authenticationManager(authenticationManager)
//    	.userDetailsService(userService).tokenStore(tokenStore);
//    }

	/**
	 * 使用密碼模式 token方法
	 */
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endopints) throws Exception {
//		
//		
//		endopints.authenticationManager(authenticationManager).userDetailsService(userService)
//		.tokenStore(tokenStore)
//		.accessTokenConverter(jwtAccessTokenConverter)
//		;
//	}
	
	
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endopints) throws Exception {
		
		
		/**
		 * jwt 配置內容增強
		 */
		
		TokenEnhancerChain enhancerChain =new TokenEnhancerChain();
		List<TokenEnhancer> delegates =new ArrayList<>();
		
		delegates.add(jwtTokenEnhancer);
		delegates.add(jwtAccessTokenConverter);
		enhancerChain.setTokenEnhancers(delegates);
		
		
		endopints.authenticationManager(authenticationManager).userDetailsService(userService)
		//配置儲存策略
		.tokenStore(tokenStore)
		.accessTokenConverter(jwtAccessTokenConverter).tokenEnhancer(enhancerChain)
		;
	}
	

	/**
	 * 自訂授權
	 * 
	 * 授權碼模式
	 * grant_type:authorization_code
	 * client_id:
	 * redirect_uri:
	 * code:
	 * scope:all
	 * 
	 * Authorization: Basic Auth
	 * 密碼模式
	 * grant_type:password
	 * username
	 * password
	 * scope
	 */

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

//		http://localhost:10084/oauth/authorize?response_type=code&client_id=admin&redirect_uri=https://tw.yahoo.com/&scope=all
		// code: 2a0iIO
		String password = passwordEncoder.encode("123456");

		// 配置grount_type 授權類型
		clients.inMemory().withClient("admin").secret(password)
		.accessTokenValiditySeconds(3600)		//token 有效時間
		.refreshTokenValiditySeconds(864000)	//刷新token
		.autoApprove(true)						//自動授權
		.authorizedGrantTypes("authorization_code", "password","refresh_token")
							 //授權碼				 密碼		刷新
		
		.scopes("all").redirectUris(url1);
	}


	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	security.tokenKeyAccess("isAuthenticated()");
	//獲取秘鑰需要身分驗證 登入時需配置
	
	}

}