package com.elton.SpringAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LuvAopExpressionUtils {
    @Pointcut("execution( * com.elton.SpringAOP.dao.*.*(..))")
    public void forDaoClass(){}

    @Pointcut("execution( * com.elton.SpringAOP.dao.*.get*(..))")
    public void forGetters(){}

    @Pointcut("execution( * com.elton.SpringAOP.dao.*.set*(..))")
    public void forSetters(){}

    @Pointcut("forDaoClass() && !(forGetters() || forSetters())")
    public void forDaoNoSettersOrGetters(){}
}
