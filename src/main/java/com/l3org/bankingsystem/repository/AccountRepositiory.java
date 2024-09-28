package com.l3org.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l3org.bankingsystem.model.Account;

public interface AccountRepositiory extends JpaRepository<Account,Long> {

}
