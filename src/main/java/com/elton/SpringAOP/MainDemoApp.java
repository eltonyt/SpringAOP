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
        Account newAccount = new Account();
        newAccount.setName("John");
        newAccount.setLevel("VIP");
        theAccountDAO.addAccount(newAccount, true);
        theAccountDAO.addReturnTypeAccount(theAccountDAO);
        theMembershipDao.addSillyAccount();
        theAccountDAO.addReturnTypeAccount();

        theAccountDAO.setName("Elton");
        theAccountDAO.setServiceNum("1");
        theAccountDAO.getName();
        theAccountDAO.getServiceNum();

//        do it again!
        System.out.println("\n let's call it again!\n");
//        theAccountDAO.addAccount();
        theMembershipDao.addSillyAccount();
        theMembershipDao.dummyMethod();

//        close the context
        context.close();
    }
}
