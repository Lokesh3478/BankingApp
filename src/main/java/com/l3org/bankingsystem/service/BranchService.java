package com.l3org.bankingsystem.service;

import com.l3org.bankingsystem.model.AccountType;
import com.l3org.bankingsystem.model.Branch;
import com.l3org.bankingsystem.repository.BranchRepository;
import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public Branch addBranch(String ifscCode, String branchName, String branchAddress) {
        Branch branch = new Branch(ifscCode, branchName, branchAddress);
        if(branchRepository.existsById(ifscCode)){
            throw new DuplicateKeyException("ifscCode");
        }
        return branchRepository.save(branch);
    }

    public Branch getBranch(String ifscCode) throws FieldValueNotFoundException {
        return branchRepository.findById(ifscCode).orElseThrow(()-> new FieldValueNotFoundException("ifscCode"));
    }
}
