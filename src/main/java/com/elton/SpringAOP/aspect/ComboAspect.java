package com.elton.SpringAOP.aspect;

import com.elton.SpringAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ComboAspect {
    @Before("com.elton.SpringAOP.aspect.LuvAopExpressionUtils.forDaoNoSettersOrGetters()")
    public void beforeDoingAnything(JoinPoint theJoinPoint){
        System.out.println("\n=================> This is happening before all methods except getters and setters.");

//        DISPLAY THE METHOD SIGNATURE
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSig) ;

//        DISPLAY METHOD ARGUMENTS
//        GET ARGS
        Object[] args = theJoinPoint.getArgs();

//        LOOP THROUGH ARGS
        for (Object tempArg : args){
            System.out.println(tempArg);
            if (tempArg instanceof Account){
                Account theAccount = (Account) tempArg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Account Level: " + theAccount.getLevel());
            }
        }

    }
}
