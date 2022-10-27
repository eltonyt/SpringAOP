package com.elton.SpringAOP.dao;

import com.elton.SpringAOP.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceNum;

//    ADD A NEW METHOD: FIND ACCOUNTS
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        // CREATE SAMPLE ACCOUNTS
        Account sampleAccount1 = new Account("John", "Silver");
        Account sampleAccount2 = new Account("Madhu", "Platinu");
        Account sampleAccount3 = new Account("Luca", "Gold");

        // ADD THEM TO OUR ACCOUNTS LIST
        myAccounts.add(sampleAccount1);
        myAccounts.add(sampleAccount2);
        myAccounts.add(sampleAccount3);

        return myAccounts;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceNum() {
        System.out.println(getClass() + ": in getServiceNum()");
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        System.out.println(getClass() + ": in setServiceNum()");
        this.serviceNum = serviceNum;
    }

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOINg MY DB WORK: ADDING ACCOUNT");
    }

    public boolean addReturnTypeAccount() {
        System.out.println(getClass() + ": ADDING ACCOUNT WITH RETURN VALUES.");
        return true;
    }

    public boolean addReturnTypeAccount(AccountDAO uselessDao) {
        System.out.println(getClass() + ": ADDING ACCOUNT WITH RETURN VALUES.");
        return true;
    }
}
