package com.elton.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    this is where we add all of our related advices for logging

//    let's start with an @Before advice

//    @Before("execution(public void com.elton.SpringAOP.dao.AccountDAO.addAccount())") - Specific Reference
//    @Before("execution(public void add*())") - Public method start with add with void return type
//    @Before("execution(public * add*())") - Public method start with add with any return types
//    @Before("execution(* add*())") - Any methods start with add with any return types
//    @Before("execution(* add*(com.elton.SpringAOP.dao.AccountDAO))") - One parameter with specific parameter type
//    @Before("execution(* add*(com.elton.SpringAOP.Account, ..))") - ANY CLASSES UNDER THIS PACKAGE AND ANY METHODS

    @Before("execution(* com.elton.SpringAOP.dao.*.*(..))")
    public void beforeAddAccountAdvice() {

        System.out.println("\n===========>>>> Executing @Before advice on method");

    }


}
