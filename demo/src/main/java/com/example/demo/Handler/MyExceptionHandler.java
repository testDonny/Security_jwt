package com.example.demo.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.security.access.AccessDeniedException;
@RestControllerAdvice
public class MyExceptionHandler {
    // 日志记录工具
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        logger.error("缺少请求参数", e);
        Response response=new Response();
        response.setError("缺少请求参数");
        response.setStatus("400");
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        Response response=new Response();
        response.setError("参数解析失败");
        response.setStatus("400");
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("参数验证失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);

        Response response=new Response();
        response.setError("参数验证失败");
        response.setStatus("400");
        
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Response handleBindException(BindException e) {
        logger.error("参数绑定失败", e);
        Map<String, Object> map = new HashMap<String, Object>();
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message =  String.format("%s:%s", field, code);
  
        Response response=new Response();
        response.setError("参数绑定失败");
        response.setStatus("400");
        
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }


    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Response handleServiceException(ConstraintViolationException e) {
        logger.error("参数验证失败", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        Response response=new Response();
        response.setError("参数验证失败");
        response.setStatus("400");
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Response handleValidationException(ValidationException e) {
        logger.error("参数验证失败", e);
        Response response=new Response();
        response.setError("参数验证失败");
        response.setStatus("400");
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }
    
    /**
     * 403 - Bad Request
     */
    
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public Response handleValidationException(AccessDeniedException e) {
        logger.error("未經過授權", e);
        Response response=new Response();
        response.setError("權限不足");
        response.setStatus("403");
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }
    
    
    /**
     * 404
     * 自訂義
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public Response handleResourceNotFoundException() {
        logger.error("該對象不存在");
    	Response response=new Response();
    	response.setError("該對象不存在");
    	response.setStatus("404");
        return response;
    }
    
 

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        Response response=new Response();
        response.setError("不支持当前请求方法");
        response.setStatus("405");
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public  Response handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        logger.error("不支持当前媒体类型", e);
        Response response=new Response();
        response.setError("不支持当前媒体类型");
        response.setStatus("500");
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }

    /**
     * 自定义异常类
     */
//    @ResponseBody
//    @ExceptionHandler(BusinessException.class)
//    public Map<String, Object> businessExceptionHandler(BusinessException e) {
//        logger.error("自定义业务失败", e);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("rspCode", e.getCode());
//        map.put("rspMsg", e.getMessage());
//        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
//        return map;
//    }


    /**
     * 获取其它异常。包括500
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Response defaultErrorHandler(Exception e) {
        logger.error("Exception", e);
        
        Response response=new Response();
        response.setError("後端內部錯誤");
        response.setStatus("500");
        
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略
        return response;
    }

}