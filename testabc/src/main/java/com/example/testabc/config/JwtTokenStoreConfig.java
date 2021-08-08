package com.example.testabc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


/**
 * 配置token 類型會有衝突
 * @author user1
 *
 */
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
//        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
//        //1.设置签名秘钥
//        accessTokenConverter.setSigningKey("test_key");
        
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("test_key");

        System.out.println(jwtAccessTokenConverter.getKey());
        return jwtAccessTokenConverter;
    }
    
    
    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer() {
		return new JwtTokenEnhancer();
    }
	

}
