//package com.example.demo;
//
//import java.util.Date;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class MyAspect {
//									
//	
////	@Before("execution(* com.example.demo.CanoPrinter.*(..))")
////	public void before() {
////		System.out.println("before test");
////	}
////	
////	@After("execution(* com.example.demo.CanoPrinter.*(..))")
////	public void after() {
////		System.out.println("after test");
////	}
//	
//	@Around("execution(* com.example.demo.CanoPrinter.*(..))")
//	public Object around(ProceedingJoinPoint pjp)throws Throwable{
//		
//		Date start =new Date();
//		
//
//		System.out.println("around before");
//		Object obj=pjp.proceed();
//		System.out.println("around after");
//		
//		Date end=new Date();
//		
//		long time=end.getTime()-start.getTime();
//		
//		System.out.println("總共執行了 : "+time+" 秒");
//		return obj;
//	}
//	
//}
