package com.quguang.springbootjwtdemo.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by 瞿广 on 2018/11/20 0020.
 */
@Aspect
@Component
@Slf4j
public class MethodAspect {

    @Pointcut("execution(public * com.quguang.springbootjwtdemo.service.TestService.*(..))")
    public void testAspect(){
    }

    @Before("testAspect()")
    public void doBefore(JoinPoint joinPoint){
        log.info("方法执行前...");

        log.info("class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        log.info("args:"+joinPoint.getArgs());
        String res=(String) joinPoint.getArgs()[0];
        
        System.out.println(res);
    }

    @After("testAspect()")
    public void doAfter(JoinPoint joinPoint){
        log.info("方法执行后...");
    }

    @AfterReturning(returning="result",pointcut="testAspect()")
    public void doAfterReturning(Object result){
        log.info("方法返回值："+result);
    }

}
