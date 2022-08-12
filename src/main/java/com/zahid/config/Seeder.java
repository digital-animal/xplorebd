package com.zahid.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zahid.models.Account;
import com.zahid.models.Role;
import com.zahid.services.AccountService;
import com.zahid.services.RoleService;

@Component
public class Seeder implements CommandLineRunner {
    
    private final Logger logger = LoggerFactory.getLogger(Seeder.class);
    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    public void loadSeedData() {

        List<Account> accounts = accountService.getAllAccounts();
        
        if(accounts.size() == 0) {

            Role user = new Role("ROLE_USER");
            Role admin = new Role("ROLE_ADMIN");

            roleService.addRole(user);
            roleService.addRole(admin);

            Set<Role> minRoles = new HashSet<>();
            minRoles.add(user);
            Set<Role> maxRoles = new HashSet<>();
            maxRoles.add(user);
            maxRoles.add(admin);

            Account account1 = new Account("alex.lee@email.com", "1234", "Alex", "Lee");
            Account account2 = new Account("lee.cooper@email.com", "1234", "Lee", "Cooper");
            Account account3 = new Account("magnus.carlsen@email.com", "1234", "Magnus", "Carlsen");
            Account account4 = new Account("john.doe@email.com", "1234", "John", "Doe");
            Account account5 = new Account("anna.smith@email.com", "1234", "Anna", "Smith");
            
            account1.setRoles(minRoles);
            account2.setRoles(minRoles);
            account3.setRoles(maxRoles);
            account4.setRoles(minRoles);
            account4.setRoles(maxRoles);

            accountService.addAccount(account1);
            accountService.addAccount(account2);
            accountService.addAccount(account3);
            accountService.addAccount(account4);
            accountService.addAccount(account5);
            
            logger.info("Number of accounts : {}", accountService.getAllAccounts().size());

        }

    }

}
