package com.elton.SpringAOP.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addSillyAccount() {
        System.out.println(getClass() + ": DOINg MY DB WORK: ADDING Silly Membership Account");
    }
}
