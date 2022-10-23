package com.elton.SpringAOP.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOINg MY DB WORK: ADDING ACCOUNT");
    }

    public boolean addReturnTypeAccount() {
        System.out.println(getClass() + ": ADDING ACCOUNT WITH RETURN VALUES.");
        return true;
    }
}
