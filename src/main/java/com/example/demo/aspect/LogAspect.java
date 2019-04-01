package com.example.demo.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect  
@Component 
public class LogAspect {
	
	private Logger logger = LoggerFactory.getLogger(LogAspect.class);
	 
	 
	 @Pointcut("execution(public * com.example.demo.controller.*.insert*(..))")
	 public void insert() {}
	 
	 @Before("insert()")
	 public void beforeInsert(JoinPoint joinPoint) {
		    // 接收到请求，记录请求内容  
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
	        HttpServletRequest request = attributes.getRequest();  
	        // 记录下请求内容  
	        logger.info("URL : " + request.getRequestURL().toString());  
	        logger.info("HTTP_METHOD : " + request.getMethod());  
	        logger.info("IP : " + request.getRemoteAddr());  
	        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
	        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
	 }
	 
	 @AfterReturning(returning = "ret", pointcut = "insert()")  
	    public void doAfterReturnInsert(Object ret) throws Throwable {  
	        // 处理完请求，返回内容  
		 logger.info("方法的返回值 : " + ret);  
	    }  
	 
	 @Pointcut("execution(public * com.example.demo.controller.*.query*(..))")
	 public void query() {}
	 
	 @Before("query()")
	 public void beforeQuery(JoinPoint joinPoint) {
		    // 接收到请求，记录请求内容  
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
	        HttpServletRequest request = attributes.getRequest();  
	        // 记录下请求内容  
	        logger.info("URL : " + request.getRequestURL().toString());  
	        logger.info("HTTP_METHOD : " + request.getMethod());  
	        logger.info("IP : " + request.getRemoteAddr());  
	        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
	        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
	 }
	 
	 @AfterReturning(returning = "ret", pointcut = "query()")  
	    public void doAfterReturnQuery(Object ret) throws Throwable {  
	        // 处理完请求，返回内容  
		 logger.info("方法的返回值 : " + ret);  
	    }  
	 
	 @Pointcut("execution(public * com.example.demo.controller.*.delete*(..))")
	 public void delete() {}
	 
	 @Before("delete()")
	 public void beforeDelete(JoinPoint joinPoint) {
		    // 接收到请求，记录请求内容  
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
	        HttpServletRequest request = attributes.getRequest();  
	        // 记录下请求内容  
	        logger.warn("URL : " + request.getRequestURL().toString());  
	        logger.warn("HTTP_METHOD : " + request.getMethod());  
	        logger.warn("IP : " + request.getRemoteAddr());  
	        logger.warn("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
	        logger.warn("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
	 }
	 
	 @AfterReturning(returning = "ret", pointcut = "delete()")  
	    public void doAfterReturnDelete(Object ret) throws Throwable {  
	        // 处理完请求，返回内容  
		 logger.warn("方法的返回值 : " + ret);  
	    }  
	 
	 
	/* @Pointcut("execution(public * com.example.demo.controller.*.*(..))")  
	    public void webLog(){}  
	 
	    @Before("webLog()")  
	    public void deBefore(JoinPoint joinPoint) throws Throwable {  
	        // 接收到请求，记录请求内容  
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
	        HttpServletRequest request = attributes.getRequest();  
	        // 记录下请求内容  
	        System.out.println("URL : " + request.getRequestURL().toString());  
	        System.out.println("HTTP_METHOD : " + request.getMethod());  
	        System.out.println("IP : " + request.getRemoteAddr());  
	        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
	        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));  
	  
	    }  
	  
	    @AfterReturning(returning = "ret", pointcut = "webLog()")  
	    public void doAfterReturning(Object ret) throws Throwable {  
	        // 处理完请求，返回内容  
	        System.out.println("方法的返回值 : " + ret);  
	    }  
	  
	    //后置异常通知  
	    @AfterThrowing("webLog()")  
	    public void throwss(JoinPoint jp){  
	        System.out.println("方法异常时执行.....");  
	    }  
	  
	    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行  
	    @After("webLog()")  
	    public void after(JoinPoint jp){  
	        System.out.println("方法最后执行.....");  
	    }  
	  
	    //环绕通知,环绕增强，相当于MethodInterceptor  
	    @Around("webLog()")  
	    public Object arround(ProceedingJoinPoint pjp) {  
	        System.out.println("方法环绕start.....");  
	        try {  
	            Object o =  pjp.proceed();  
	            System.out.println("方法环绕proceed，结果是 :" + o);  
	            return o;  
	        } catch (Throwable e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  */
}
