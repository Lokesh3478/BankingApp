package com.l3org.bankingsystem.service;

import com.l3org.bankingsystem.model.AccountType;
import com.l3org.bankingsystem.repository.AccountTypeRepository;
import com.l3org.bankingsystem.service.exceptions.FieldValueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    public AccountTypeService(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public AccountType addAccountType(int accountTypeId, String accountTypeName, double interestRate, double minimumBalance, double overdraftLimit, double withdrawalLimit, double depositLimit, boolean isMinorAccount) {
        AccountType accountType = new AccountType(accountTypeId,accountTypeName,interestRate,minimumBalance,overdraftLimit,withdrawalLimit,depositLimit,isMinorAccount);
        if(accountTypeRepository.existsById(accountTypeId)) {
            throw new DuplicateKeyException("accountTypeId");
        }
        return accountTypeRepository.save(accountType);
    }

    public AccountType getAccountTypeById(int id) throws FieldValueNotFoundException {
        return accountTypeRepository.findById(id).orElseThrow(()->new FieldValueNotFoundException("accountTypeId"));
    }
}
