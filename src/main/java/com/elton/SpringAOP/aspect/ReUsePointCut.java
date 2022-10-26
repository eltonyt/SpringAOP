package com.elton.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReUsePointCut {

//    @Pointcut("execution(* com.elton.SpringAOP.dao.*.*(..))")
    private void forDaoPackage(){}

//    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n===================> HELLO: " + this.getClass());
    }

//    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n===================> PERFORMING API ANALYTICS");
    }
}
