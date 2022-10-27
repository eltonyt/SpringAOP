package com.elton.SpringAOP;

import com.elton.SpringAOP.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturnDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("\n\n Main Program: After Returning Demo App");
        System.out.println("-----------------");
        System.out.println(theAccounts);
        System.out.println("\n");
        context.close();
    }
}
