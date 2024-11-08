package com.l3org.bankingsystem.service;

import com.l3org.bankingsystem.model.*;
import com.l3org.bankingsystem.repository.AccountRepository;
import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountTypeService accountTypeService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private LoginService loginService;

    public AccountService(AccountRepository accountRepository, AccountTypeService accountTypeService, BranchService branchService) {
        this.accountRepository = accountRepository;
        this.accountTypeService = accountTypeService;
        this.branchService = branchService;
    }

    public Account addAccount(long accountNo, int accountTypeId, String userId, String aadhaarNumber, String mobileNumber, String ifscCode, double balance,
                              Date dateOfCreation, String mpin) throws FieldValueNotFoundException {
        User user = null;
        try{
            user = loginService.getUser(userId);
        } catch (FieldValueNotFoundException ignored) {}
        AccountType accountType = accountTypeService.getAccountTypeById(accountTypeId);
        Branch branch = branchService.getBranch(ifscCode);
        Account account = new Account(accountNo,accountType,user,aadhaarNumber,mobileNumber,branch,new ArrayList<>(),new ArrayList<>(),balance,dateOfCreation,mpin);
        if(accountRepository.existsById(accountNo)) {
            throw new DuplicateKeyException("accountNo");
        }
        if(accountRepository.existsByAccountInformationAadhaarNumber(aadhaarNumber)){
            throw new DuplicateKeyException("aadhaarNumber");
        }
        if(accountRepository.existsByAccountInformationMobileNumber(mobileNumber)){
            throw new DuplicateKeyException("mobileNumber");
        }
        return accountRepository.save(account);
    }

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountByMobileNumber(String mobileNumber) throws FieldValueNotFoundException {
        if(accountRepository.existsByAccountInformationMobileNumber(mobileNumber)){
            return accountRepository.findAccountByAccountInformationMobileNumber(mobileNumber);
        }
        throw new FieldValueNotFoundException("mobileNumber");
    }

    public Account getAccountByAadhaarNumber(String aadhaarNumber) throws FieldValueNotFoundException {
        if(accountRepository.existsByAccountInformationAadhaarNumber(aadhaarNumber)){
            return  accountRepository.findAccountByAccountInformationAadhaarNumber(aadhaarNumber);
        }
        throw new FieldValueNotFoundException("aadhaarNumber");
    }

    public Account setMpin(String mpin,Account account) {
        account.getAccountInformation().setMpin(mpin);
        accountRepository.save(account);
        return account;
    }
}
