package com.zahid.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zahid.models.Account;
import com.zahid.repositories.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().forEach(accountList::add);
        return accountList;
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    public void updateAccount(Account account) {
        Account t = accountRepository.findById(account.getId()).get();
        t = account;
        accountRepository.save(t);
    }
}
