package com.example.testabc.config;

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
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.example.testabc.user.dao.UsersRepositorys;
import com.example.testabc.user.service.UserDetailsServiceImpl;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	String url = "https://tw.yahoo.com/";

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
	@Qualifier("jwtTokenStore")
	private TokenStore tokenStore;

	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

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
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endopints) throws Exception {
		endopints.authenticationManager(authenticationManager).userDetailsService(userService).tokenStore(tokenStore)
				.accessTokenConverter(jwtAccessTokenConverter);
	}

	/**
	 * 自訂授權
	 */

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

//		http://localhost:10084/oauth/authorize?response_type=code&client_id=admin&redirect_uri=https://tw.yahoo.com/&scope=all
		// code: 2a0iIO
		String password = passwordEncoder.encode("123456");

		// 配置grount_type 授權類型
		clients.inMemory().withClient("admin").secret(password).accessTokenValiditySeconds(3600)

				.authorizedGrantTypes("authorization_code", "password").scopes("all").redirectUris(url);
	}

//    @Bean
//
//    public JwtAccessTokenConverter accessTokenConverter() {
//
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//
//        converter.setSigningKey("123"); //Token暫用symmetric key "123"來加密
//
//        return converter;
//
//    }
//
//   
//
//    @Bean
//
//    public TokenStore jwtTokenStore() {
//
//        return new JwtTokenStore(accessTokenConverter());
//
//    }

}