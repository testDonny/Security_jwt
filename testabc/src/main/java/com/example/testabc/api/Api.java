package com.example.testabc.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.testabc.user.model.Users;
import com.example.testabc.user.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;


//@ApiResponses(value = {
//        @ApiResponse(code = 404, message = "Applicants not found")
//})

@RestController
@Slf4j
//@Controller		RestController
public class Api {
	
	@Autowired
	private UserService userService;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/test")
//	@ResponseBody		RestController
	public String hello() {
	return "test";	
	}
	
	
//	//查資料
//	@GetMapping("/select/{id}")
//	public ResponseEntity<Users> select(@PathVariable("id")String id) {
//		return id;
//		
//	}
//	
	//查所有資料
	@GetMapping("/select")
	public ResponseEntity<List<Users>> selects() {
		
		ResponseEntity<List<Users>> result=null;
		
		List<Users> users=userService.select();

		result=ResponseEntity.ok().body(users);
		return result;
		
	}
	
	
	//查所單筆資料
	@ApiOperation(value = "查詢單個訂單，Get an Order by Id")
	@GetMapping("/select/{username}")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<Users> select(@PathVariable String username) {
		
		ResponseEntity<Users> result=null;
		
		try {
			
			
			Users users=userService.findByUsername(username);

			//測試
			System.out.println(users);
			
			if(users!=null) {
				
			
			result=ResponseEntity.ok().body(users);
			
			System.out.println("test1	: "+result);
			}
			else{
				result=ResponseEntity.notFound().build();
				System.out.println("test2	:"+result);
			}
			
		}catch(Exception e) {
			System.out.println("test");
		}
		
		
		return result;
		
	}
	
	@PostMapping("/check")
	public ResponseEntity<Users>check(@RequestBody Users users,HttpServletRequest request){
		
		ResponseEntity<Users> result=null;
		
		Users check=userService.findByUsernameAndPassword
				(users.getUsername(), users.getPassword());
		
		if(check!=null) {
			result=ResponseEntity.ok().body(users);
		
			request.getSession().setAttribute("name",users.getUsername()+","+users.getPassword());
			
		}else {
			result = ResponseEntity.notFound().build();
		}

		System.out.println(result);
		return result;
		
	}
	
	@GetMapping("/resetsession")
	public String session(HttpServletRequest request) {
		
		request.getSession().removeAttribute("name");
//		request.getSession().invalidate();
		return "清除成功";
		
	}
	
	
//	插入資料
	@PostMapping("/insert")
	public ResponseEntity<Users> insert(@RequestBody Users users) {
		
		ResponseEntity<Users> result=null;
		
		Users userResult=userService.insert(users);
		
		result = ResponseEntity.ok().body(userResult);
		
		return result;
		
	}
}
