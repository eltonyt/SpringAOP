package com.elton.SpringAOP.aspect;


import com.elton.SpringAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Order(3)
public class MyCloudLogAsyncAspect {

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
