package com.l3org.bankingsystem.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("Customer")
public class CustomerUser extends User {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Account> accountList;

    public CustomerUser() {
    }

    public CustomerUser(String userId, String userName, String mailId, String password, String mobileNumber, Date dateOfBirth, Date dateOfCreation, String status, List<Account> accountList) {
        super(userId, userName, mailId, password, mobileNumber, dateOfBirth, dateOfCreation, status);
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    @Transactional
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "CustomerUser{" +
                super.toString() +
                "accountList=" + accountList +
                '}';
    }
}
