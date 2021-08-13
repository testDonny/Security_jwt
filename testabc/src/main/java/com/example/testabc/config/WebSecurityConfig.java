package com.example.testabc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


//
//import com.example.testabc.user.service.impl.MyServiceImpl;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Autowired
//	private MyAccessDenidHandler myAccessDenidHandler;

//	 
//	  @Override
//	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	   auth
//	    .inMemoryAuthentication()
//	     .withUser("user")
//	       .password("password")
//	       .roles("USER");
//	  }
//	
	
	
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//            .ignoring()
//            .antMatchers("/resources/**");
//    }
//  

//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
//	@Autowired
//	private AuthenticationSuccessHandler authenticationSuccessHandler;
//	@Autowired
//	private AuthenticationFailureHandler authenticationFailureHandler;
//	
//	@Autowired
//	private UserService userService;
	
//	@Autowired
//	private MyServiceImpl myServiceImpl;
	/**
	 * 保持登入表格
	 * @return
	 */
//	@Bean
//	public PersistentTokenRepository persistentTokenRepository() {
//		JdbcTokenRepositoryImpl jdbcTokenRepository=new JdbcTokenRepositoryImpl();
//		jdbcTokenRepository.setDataSource(dataSource);
////		jdbcTokenRepository.setCreateTableOnStartup(true);
//		//第一次自動建表
//		return jdbcTokenRepository;
//		
//	}
	
	
	/**
	 * 密碼授權模式
	 */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
//		String url="https://tw.yahoo.com/";
//		
//		http.formLogin()						//登入
//		.loginPage("/test/login")				//登入的頁面
//		.loginProcessingUrl("/test/check")		//登入訪問路徑
//		.successForwardUrl("/test/success")		//登入成功POST路徑
////		.successHandler(new MyAuthenticationSuccessHandler(url))	//登入成功處理
//		.failureForwardUrl("/test/error");		//登入失敗POST路徑
//		.failureHandler(new MyAuthenticationFailureHandler("/test/error"));
//		
//	http.authorizeRequests()
//	.antMatchers("/test/home")
//	.permitAll().antMatchers("/test/login")
//	.permitAll().
//	antMatchers("js/**","/image/**","/css/**").permitAll().
////	antMatchers("/test/hello").hasAuthority("admin").	一個權限
////	antMatchers("/test/hello").hasAnyAuthority("admin","abc")
//	antMatchers("/test/hello").hasRole("test")
////	.antMatchers("/test/home").hasIpAddress
////	("127.0.0.1")
//	.anyRequest().authenticated();
////	.anyRequest().access(myServiceImpl.hasPermission(request, authentication));
//	
//	
		
		http.authorizeRequests()
		.antMatchers("/oauth/**","/login/**","/select","/select/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.permitAll().and()
		.csrf().disable();
		
		
//		http.csrf().disable().authorizeRequests()
//		.antMatchers("/oauth/**","/test/login","/test/logout").permitAll()
////		.antMatchers("js/**","/image/**","/css/**")
////		.permitAll()
//		.anyRequest().authenticated()
//		.and().formLogin().permitAll();
//		.loginPage("/test/login")
//		.loginProcessingUrl("/test/check")
//		.successForwardUrl("/test/success")
//		.failureForwardUrl("/test/error");
		
		
//		http.formLogin()						//登入
//		.loginPage("/test/login")				//登入的頁面
//		.loginProcessingUrl("/test/check")		//登入訪問路徑
//		.successForwardUrl("/test/success")		//登入成功POST路徑
////		.successHandler(new MyAuthenticationSuccessHandler(url))	//登入成功處理
//		.failureForwardUrl("/test/error");		//登入失敗POST路徑
////		.failureHandler(new MyAuthenticationFailureHandler("/test/error"));
		
//		http.authorizeRequests()
//		//error 不需要認證
////		.antMatchers("/test/home").permitAll()
//		// login 不需要認證
//		.antMatchers("/test/login").permitAll()
////		
////		.regexMatchers(".+[.]png").permitAll();
//		.regexMatchers(HttpMethod.POST,"/bbb").permitAll()
//		//所有請求都必須被認證,必須登入後被訪問
//		.anyRequest().authenticated();
		
		

//		http.authorizeRequests()
//		.antMatchers
////		("/test/loginsuccess").hasAnyAuthority("admins")			//需樣有管理員權限不需要驗證
////		("/test/loginsuccess").hasAnyAuthority("admins","manager")	//多個權限
//		("/test/success").permitAll()					//手動前輟處理ROLE_
//		.antMatchers("/test/home").permitAll()						//所有人皆可以訪問
//		.anyRequest().authenticated().and()
//		.rememberMe().tokenRepository(persistentTokenRepository())
//		.tokenValiditySeconds(60).userDetailsService(userDetailsService);
//		
//	http.csrf().disable();		//關閉csrf防護
////		不對GET HEAD TRACE OPTIONS  進行防護		
		http.exceptionHandling().accessDeniedPage("/test/unauth");	//403頁面
//	http.exceptionHandling().accessDeniedHandler(myAccessDenidHandler);

//		
		http.logout().logoutUrl("/test/logout").logoutSuccessUrl("/test/home").permitAll();
				//登出
//	
	    
	     
	    
//	    
//	    http.formLogin()				
//		.loginPage("/test/login")		
//		.loginProcessingUrl("/test/check")	
//		.defaultSuccessUrl("/test/success").permitAll().and().cors()
//	        .and()
//	        // 跨域偽造請求限制無效
//	        .csrf().disable()
//	        .authorizeRequests()
//	        // 訪問/data需要ADMIN角色
//	        .antMatchers("/test/success").hasRole("ADMIN")
//	        // 其餘資源任何人都可訪問
//	        .anyRequest().permitAll()
//	        .and()
//	        // 新增JWT登入攔截器
//	        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//	        // 新增JWT鑑權攔截器
//	        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//	        .sessionManagement()
//	        // 設定Session的建立策略為：Spring Security永不建立HttpSession 不使用HttpSession來獲取SecurityContext
//	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	        .and()
//	        // 異常處理
//	        .exceptionHandling()
//	        // 匿名使用者訪問無許可權資源時的異常
//	        .authenticationEntryPoint(new JWTAuthenticationEntryPoint());
//		
	    
	    
	    
		
	}
	
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    
//    	
///*		原本的定義方式    	
////    	BCryptPasswordEncoder bcryptPasswordEncoder=new BCryptPasswordEncoder();
////    	
////    	String username="aaa";
////    	String password="bbb";
////    	
////        String bcryptPassword=bcryptPasswordEncoder.encode(password);
////    	
////    	auth
////            .inMemoryAuthentication()
////            .withUser(username).password(bcryptPassword).roles("admin");
// */   	
//    	
//    	//自訂義驗證方式
//    	auth.userDetailsService(userDetailsService);
//    }
	
	
//	  @Bean
//	  CorsConfigurationSource corsConfigurationSource() {
//	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    // 註冊跨域配置
//	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//	    return source;
//	  }
    
    
    //基本配置
    @Bean
    PasswordEncoder password() {
    	return new BCryptPasswordEncoder();
    }

}