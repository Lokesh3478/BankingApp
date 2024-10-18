package com.l3org.bankingsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("Admin")
public class AdminUser extends User {


    public AdminUser() {
    }

    public AdminUser(String userId, String userName, String mailId, String password, String mobileNumber, Date dateOfBirth, Date dateOfCreation, String status, String adminCode) {
        super(userId, userName, mailId, password, mobileNumber, dateOfBirth, dateOfCreation, status);
        super.setAdminCode(adminCode);
    }

    public String getAdminCode() {
        return super.getAdminCode();
    }

    public void setAdminCode(String adminCode) {
        super.setAdminCode(adminCode);
    }
}
