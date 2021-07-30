package com.example.testabc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	String url="https://tw.yahoo.com/";
	
	
	
    @Autowired
    private AuthenticationManager authenticationManager;
	
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
    
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)
            throws Exception {
        super.configure(security);
    }
    
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		String password=passwordEncoder.encode("123");
		
		//配置grount_type 授權類型
        clients.inMemory().withClient("ROLE_test").secret(password)
        .accessTokenValiditySeconds(3600)
        .authorizedGrantTypes("authorization_code")
        .scopes("openid", "all").redirectUris(url);
	}
}
