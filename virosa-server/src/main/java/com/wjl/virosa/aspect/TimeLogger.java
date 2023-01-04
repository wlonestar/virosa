package com.wjl.virosa.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author <a href="mailto:wlonestar@163.com">wjl</a>
 * @version 0.0.1
 * @time 2023/1/4 23:21
 */
@Slf4j
@Aspect
@Component
public class TimeLogger {

  private Date begin;
  private Signature signature;
  private String methodName;

  private void formatMethodName() {
    methodName = signature.getDeclaringTypeName() + "." + signature.getName() + "()";
  }

  @Pointcut("@within(com.wjl.virosa.annotation.TimeLog)")
  public void logClass() {
  }

  @Pointcut("@within(com.wjl.virosa.annotation.TimeLogMethod)")
  public void logMethod() {
  }

  @Pointcut("@within(com.wjl.virosa.annotation.TimeLogNotMethod)")
  public void notLogMethod() {
  }

  @Before("(logClass() || logMethod()) && !notLogMethod()")
  public void adviceBefore(JoinPoint joinPoint) {
    begin = new Date();
    signature = joinPoint.getSignature();
    formatMethodName();
  }

  @After("(logClass() || logMethod()) && !notLogMethod()")
  public void adviceAfter(JoinPoint _joinPoint) {
    Date end = new Date();
    double res = (end.getTime() - begin.getTime()) / 1000.0;
    log.info("{} cost {} s", methodName, res);
  }

  @AfterThrowing("(logClass() || logMethod()) && !notLogMethod()")
  public void adviceAfterThrowing(JoinPoint _joinPoint) {
    log.error("error in {}", methodName);
  }

}
