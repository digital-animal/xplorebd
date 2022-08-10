package com.zahid.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zahid.models.Account;
import com.zahid.services.AccountService;

@Controller
public class RegisterController {
    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    
    @Autowired
    AccountService accountService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        logger.info("Register Form");
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/register")
    public String registerFormSubmit(@ModelAttribute Account account) {
        accountService.addAccount(account);
        
        System.out.println(account);
        logger.info("Account Created");
        return "redirect:/";
    }
}
