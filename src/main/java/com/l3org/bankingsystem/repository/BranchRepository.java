package com.l3org.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l3org.bankingsystem.model.Branch;

public interface BranchRepository extends JpaRepository<Branch,String> {

}
