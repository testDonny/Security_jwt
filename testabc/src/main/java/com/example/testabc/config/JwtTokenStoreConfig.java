package com.example.testabc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class JwtTokenStoreConfig {

	
	@Bean
	public TokenStore jwtTokenStore() {
		
		return new JwtTokenStore
		(jwtAccessTokenConverter());
	}
	
//	/**
//	 * 設置token 密鑰
//	 * @return
//	 */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        //1.设置签名秘钥
        accessTokenConverter.setSigningKey("test_key");
        return accessTokenConverter;
    }
    
    

	

}
