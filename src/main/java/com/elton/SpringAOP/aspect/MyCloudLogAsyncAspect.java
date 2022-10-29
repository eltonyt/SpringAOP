package com.elton.SpringAOP.aspect;


import com.elton.SpringAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Order(3)
public class MyCloudLogAsyncAspect {

    @Around("execution(* com.elton.SpringAOP.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===========>>>>>> Executing @Around on method: " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //execute the method
        Object result = theProceedingJoinPoint.proceed();

        //get end time
        long end = System.currentTimeMillis();

        //calculate the time window
        long duration = end - begin;
        System.out.println("\n ======> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }

    @After("execution(* com.elton.SpringAOP.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===========>>>>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.elton.SpringAOP.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===========>>>>>> Excuting @AfterReturning on method: " + method);

        System.out.println("\n===========>>>>>> The exception is: " + theExc);
    }

    // ADD A NEW ADVICE FOR @AFTERRETURNING ON THE FINDACCOUNTS METHOD
    @AfterReturning(
            pointcut = "execution(* com.elton.SpringAOP.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // PRINT OUT WHICH METHOD WE ARE ADVISING ON
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n===========>>>>>> Excuting @AfterReturning on method: " + method);

        // PRINT OUT THE RESULTS OF THE METHOD CALL
        System.out.println("\n===========>>>>>> result is: " + result);

        // LET'S POST-PROCESS THE DATA ... MODIFY IT :-)

        // CONVERT THE ACCOUNT NAMES TO UPPERCASE
        convertAccountNamesToUpperCase(result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // LOOP THROUGH ACCOUNTS
        for (Account account : result) {
            // GET UPPERCASE VERSION OF NAME & UPDATE THE NAME ON THE ACCOUNT
            account.setName(account.getName().toUpperCase());
        }
    }

    @Before("com.elton.SpringAOP.aspect.LuvAopExpressionUtils.forDaoNoSettersOrGetters()")
    public void logToCloud(){
        System.out.println("\n=================> Storing Log.");
    }
}
