package com.l3org.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l3org.bankingsystem.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {

}
