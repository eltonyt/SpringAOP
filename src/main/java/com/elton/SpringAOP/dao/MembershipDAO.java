package com.elton.SpringAOP.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addSillyAccount() {
        System.out.println(getClass() + ": DOINg MY DB WORK: ADDING Silly Membership Account");
        return true;
    }
}
