package com.l3org.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l3org.bankingsystem.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.accountInformation.aadhaarNumber = ?1")
    boolean existsByAccountInformationAadhaarNumber(String aadhaarNumber);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.accountInformation.mobileNumber = ?1")
    boolean existsByAccountInformationMobileNumber(String mobileNumber);

    @Query
    Account findAccountByAccountInformationAadhaarNumber(String aadharNumber);

    @Query
    Account findAccountByAccountInformationMobileNumber(String mobileNumber);
}

