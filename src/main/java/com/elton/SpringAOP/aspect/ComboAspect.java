package com.elton.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ComboAspect {
    @Before("com.elton.SpringAOP.aspect.LuvAopExpressionUtils.forDaoNoSettersOrGetters()")
    public void beforeDoingAnything(){
        System.out.println("\n=================> This is happening before all methods except getters and setters.");
    }
}
