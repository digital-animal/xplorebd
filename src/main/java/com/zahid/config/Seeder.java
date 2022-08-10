package com.zahid.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zahid.models.Account;
import com.zahid.services.AccountService;

@Component
public class Seeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(Seeder.class);
    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {

        List<Account> accounts = accountService.getAllAccounts();
        
        if(accounts.size() == 0) {
            Account account1 = new Account("testuser1@email.com ", "1234", "John", "Doe");
            Account account2 = new Account("testuser2@email.com ", "1234", "Alex", "Lee");
            Account account3 = new Account("testuser3@email.com ", "1234", "Lee", "Cooper");
            Account account4 = new Account("testuser4@email.com ", "1234", "Jane", "Doe");
            Account account5 = new Account("testuser5@email.com ", "1234", "Robert", "Dew");
            
            accountService.addAccount(account1);
            accountService.addAccount(account2);
            accountService.addAccount(account3);
            accountService.addAccount(account4);
            accountService.addAccount(account5);
            
            logger.info("Number of accounts : {}", accountService.getAllAccounts().size());

        }

    }

}
