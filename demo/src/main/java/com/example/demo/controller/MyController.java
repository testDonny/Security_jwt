package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Handler.MyException;


@RestController
@Validated
public class MyController {

//	@Autowired
//	@Qualifier("canoPrinter")
//	private Printer printer;
	

	@RequestMapping("/insert")
	public String inserts(String id) {
		
//		System.out.println(student.getId());
//		
//		System.out.println(student.getName());
		
	

		return null;
		
	}
	
//	
//	@RequestMapping("/test")
//	public Student test() {
//		List<String> test=new ArrayList<>();
//		test.add("蘋果");
//		test.add("橘子");
//		Student student=new Student();
//		student.setName("abc");
////		student.setList(test);
//
////		printer.print("abc");
//		return student;
//	}
//	
////	@RequestMapping("/insert")
////	public Student insert(@RequestParam String id,@RequestParam String name) {
////		
////		Student student=new Student();
////		student.setId(id);
////		student.setName(name);
////		return student;
////		
////	}
//	
//
//	
//	@RequestMapping("/insertbody")
//	public ResponseEntity<Student> insert(@RequestBody Student student) {
//		System.out.println(student.getName());
//		System.out.println(student.getId());
//		
//		
//		ResponseEntity<Student> result=null;
//		
//		
////		if(student!=null) {
//			result=ResponseEntity.ok().body(student);
//
//
//
////		}else {
//			if(student!=null) 
//		throw new MyException();
////		}
//
//				
////		
////		throw new RuntimeException("testree01");
////		
//			return result;
//	}
//	
//	
//	@RequestMapping("/header")
//	public String header(@RequestHeader(name="Content-Type") String info) {
//
//		System.out.println(info);
//		return "hello";
//		
//	}
//	
//	@GetMapping("/variable/id/{id}")
//	public String variables(@PathVariable(required=false)
//	Integer id) {
//
//		System.out.println(id);
//		return "get";
//	}
//	
//	
//	@GetMapping("/result")
//	public String variable(@RequestBody @Valid Student student) {
//
//		System.out.println(student.getId());
//		System.out.println(student.getName());
////		System.out.println(student.getList());
//		return "result";
//	}
//	
//	@GetMapping("/results/{id}")
//	public String results(@PathVariable @Min(100) Integer id) {
//
//		System.out.println(id);
//
//		return "result";
//	}
//	
//	
//	@PutMapping("/variable/id/{id}/name/{name}")
//	public String variables(@PathVariable Integer id
//			,@PathVariable String name) {
//
//		System.out.println(id);
//		System.out.println(name);
//		return "put";
//	}
//	
//	
//	@RequestMapping("/variable")
//	public Student Products(@RequestParam String id
//			,@RequestParam String name
////			,@PathVariable List<String> list
////			,@PathVariable List<Std> std
//			) {
//
//		Student student=new  Student();
//		student.setId(id);
//		student.setName(name);
////
//		
//		return student;
//	}
//	
	
}
