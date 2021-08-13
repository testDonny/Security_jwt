package com.example.testabc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import com.alibaba.cloud.commons.lang.StringUtils;
//import com.example.testabc.config.JwtConfig;


@RequestMapping(value="/test")
@RestController
//@RefreshScope
		//配置自動更新
public class Controller {

	Logger logger = LoggerFactory.getLogger(getClass());
	

	
	
	@GetMapping("/home")
	public ModelAndView go() {

		logger.debug("test1");
		
		System.out.println("test");
		ModelAndView m = new ModelAndView("home");
		return m;

	}
	@GetMapping("/login")
	public ModelAndView login() {
	
		ModelAndView m = new ModelAndView("login");
		return m;
	}
	
	/**
	 * 403錯誤
	 * @return
	 */
	@GetMapping("/unauth")
	public ModelAndView error403() {
		ModelAndView m = new ModelAndView("errer403");
		return m;
	}
	
	/**
	 * regexMatchers
	 * 測試使用
	 * @return
	 */
	@GetMapping("/bbb")
	@ResponseBody
	public String bbb() {
		
		return "bbb";
	}
	
	/**
	 * 帳號密碼錯誤
	 * @return
	 */
	
	@PostMapping("/error")
	public ModelAndView error() {
		ModelAndView m = new ModelAndView("error");
		return m;
	}
	
	
//	@GetMapping("/loginsuccess")
//	@Secured({"ROLE_test","ROLE_admins"})
	//註解方式處理權限
//	@PostAuthorize("hasAnyAuthority('ROLE_test')")
	//執行完方法裡的結果再判斷權限
//	@PreAuthorize("hasAnyAuthority('ROLE_test')")
//	@PreAuthorize("hasRole('ROLE_test') AND hasRole('admins')")
//	@PostFilter("filterObject.username== 'admin1'")
	//方法回傳值的過濾
//	public List<User> success() {
//		System.out.println("123456");
//		
//		ArrayList<User> list=new ArrayList<>();	
//		list.add(new User("1","admin2","666","ss"));
//		list.add(new User("2","admin1","777","ss"));
//		return list;
//	}
	

	//傳入方法的值過濾
//	@PreFilter("filterObject.id==1")
	@PostMapping("/success")	
	/**
Content-Type:application/json
[{"id":2,"username":"A","password":"99"}]
	 */
	
	//public ModelAndView successTest(@RequestBody List<User> list) {
	public ModelAndView successTest() {
//		list.forEach(t->{
//			System.out.println("id:"+t.getId()+"\n username:"+t.getUsername()+"\n password "+t.getPassword());
//		});
//		
		
		ModelAndView m = new ModelAndView("success");
		
		return m;
	}
	

	/**
	 * 檢查
	 * @return
	 */
	@PostMapping("/check")
	public String check() {
		logger.debug("loginsuccess");
	
		return "check";
	}
	
	@GetMapping("/hello")
	public String hello() {
		
		System.out.println("s");
		
		return "hello";
	}
	
	/**
	 * 登出頁面
	 * @return
	 */
	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView m = new ModelAndView("logout");
		return m;	
	}
	
}
