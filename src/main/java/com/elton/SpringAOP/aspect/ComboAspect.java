package com.elton.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ComboAspect {

    @Pointcut("execution( * com.elton.SpringAOP.dao.*.*(..))")
    private void forDaoClass(){}

    @Pointcut("execution( * com.elton.SpringAOP.dao.*.get*(..))")
    private void forGetters(){}

    @Pointcut("execution( * com.elton.SpringAOP.dao.*.set*(..))")
    private void forSetters(){}

    @Pointcut("forDaoClass() && !(forGetters() || forSetters())")
    private void forDaoNoSettersOrGetters(){}

    @Before("forDaoNoSettersOrGetters()")
    public void beforeDoingAnything(){
        System.out.println("\n=================> This is happening before all methods except getters and setters.");
    }
}
