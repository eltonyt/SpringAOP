package com.elton.SpringAOP;

import com.elton.SpringAOP.dao.AccountDAO;
import com.elton.SpringAOP.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
//        read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

//        get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDao = context.getBean("membershipDAO", MembershipDAO.class);

//        call the bussiness method
        theAccountDAO.addAccount();
        theMembershipDao.addSillyAccount();
        theAccountDAO.addReturnTypeAccount();

//        do it again!
        System.out.println("\n let's call it again!\n");
        theAccountDAO.addAccount();
        theMembershipDao.addSillyAccount();

//        close the context
        context.close();
    }
}
