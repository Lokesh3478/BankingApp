package com.l3org.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l3org.bankingsystem.model.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {

}
