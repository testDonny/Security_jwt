//package com.example.demo;
//
//import java.util.Date;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//						//,InitializingBean
//public class CanoPrinter implements Printer{
////	@Value("${my.count}")
////	private int count;
//	
////	@PostConstruct
////	public void initialize() {
////		count=5;
////	}
//	
////	@Value("${my.name}")
////	private String name;
////	
////	@Value("${my.age}")
////	private String age;
////	
////	@Value("${unknow:Amy}")
////	private String test;
//	
//	@Override
//	public void print(String message) {
////		count--;
////		System.out.println("剩餘使用次數: "+count);
////		System.out.println("Canon印表機"+message);
////		System.out.println(name+" : "+age+" : "+test);
////		
////		Date start =new Date();
////		
////		Date end=new Date();
////		
////		long time=end.getTime()-start.getTime();
////		
////		System.out.println("總共執行了 : "+time+" 秒");
//	}
//
//	@Override
//	public void printColor(String message) {
//		
//		Date start=new Date();
//		
//		System.out.println("HP印表機(彩色)" +message);
//		
//		Date end=new Date();
//		
//		long time =end.getTime()-start.getTime();
//		
//		System.out.println("總共執行了 : "+time+" 秒");
//	}
//
////	@Override
////	public void afterPropertiesSet() throws Exception {
////		count=5;
////		
////	}
//
//}
