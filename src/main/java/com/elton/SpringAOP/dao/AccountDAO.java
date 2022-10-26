package com.elton.SpringAOP.dao;

import com.elton.SpringAOP.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

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
