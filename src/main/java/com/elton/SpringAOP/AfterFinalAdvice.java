package com.elton.SpringAOP;

import com.elton.SpringAOP.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinalAdvice {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

//        get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> theAccounts = null;
        try {
            // add a boolean flag to simulat exception;
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception e) {
            System.out.println("\n\n Main Program: After Throwing Advice");
        }
    }
}
