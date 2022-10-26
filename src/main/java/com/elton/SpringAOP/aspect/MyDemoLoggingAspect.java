package com.elton.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    this is where we add all of our related advices for logging

//    let's start with an @Before advice

//    @Before("execution(public void com.elton.SpringAOP.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(public * add*())")
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n===========>>>> Executing @Before advice on method");

    }
}
