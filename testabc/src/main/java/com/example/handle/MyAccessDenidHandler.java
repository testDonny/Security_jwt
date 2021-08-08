//package com.example.handle;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyAccessDenidHandler implements AccessDeniedHandler{
//
//	@Override
//	public void handle(HttpServletRequest request, HttpServletResponse response,
//			AccessDeniedException accessDeniedException) throws IOException, ServletException {
//	
//			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//			
//			response.setHeader("Content-Type", "application/json;charset=utf-8");
//			PrintWriter writer=response.getWriter();
//			
//			writer.write("{\"status\":\"error\",\"msg\":\"權限不足,請聯繫管理員\"}");
//			
//			writer.flush();
//			writer.close();
//	}
//
//}
