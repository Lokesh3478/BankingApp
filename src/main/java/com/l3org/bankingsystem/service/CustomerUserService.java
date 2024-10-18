package com.l3org.bankingsystem.service;

import com.l3org.bankingsystem.model.Account;
import com.l3org.bankingsystem.model.CustomerUser;
import com.l3org.bankingsystem.repository.CustomerUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerUserService {
    @Autowired
    private CustomerUserRepository customerUserRepository;
    @Autowired
    private AccountService accountService;

    public CustomerUserService(CustomerUserRepository customerUserRepository, AccountService accountService) {
        this.customerUserRepository = customerUserRepository;
        this.accountService = accountService;
    }

    @Transactional
    public boolean addAccount(CustomerUser customerUser, Account account) {
        // Ensure accountList is initialized
        if (customerUser.getAccountList() == null) {
            customerUser.setAccountList(new ArrayList<>());
        }

        account.setUser(customerUser);
        customerUser.getAccountList().add(account);
        customerUserRepository.save(customerUser);
        return true;
    }
}
