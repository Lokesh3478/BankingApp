package com.l3org.bankingsystem.service;

import com.l3org.bankingsystem.model.Account;
import com.l3org.bankingsystem.model.AccountType;
import com.l3org.bankingsystem.model.Branch;
import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private AccountTypeService accountTypeService;

    public AdminService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account addAccount(long accountNo, int accountTypeId, String userId, String aadhaarNumber, String mobileNumber, String ifscCode, double balance,double creditLimit,
                              Date dateOfCreation, String mpin) throws FieldValueNotFoundException {
        return accountService.addAccount(accountNo,accountTypeId,userId,aadhaarNumber,mobileNumber,ifscCode,balance,creditLimit,dateOfCreation,mpin);
    }

    public Branch addBranch(String ifscCode, String branchName, String branchAddress){
        return branchService.addBranch(ifscCode,branchName,branchAddress);
    }
    public AccountType addAccountType(int accountTypeId, String accountTypeName, double interestRate, double minimumBalance, double overdraftLimit, double withdrawalLimit, double depositLimit, boolean isMinorAccount){
        return accountTypeService.addAccountType(accountTypeId,accountTypeName,interestRate,minimumBalance,overdraftLimit,withdrawalLimit,depositLimit,isMinorAccount);
    }
}
